package org.open918.lib;

import org.open918.lib.domain.Rct2Format;
import org.open918.lib.domain.Ticket;
import org.open918.lib.domain.TicketField;
import org.open918.lib.domain.TicketFlag;
import org.open918.lib.util.ZxingUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Created by Joel Haasnoot on 22/04/15.
 * Created by Thomas on 23/04/15
 */

public class UicTicketParser {


    private final static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmm");
    public static final int TICKET_BLOCK_NAME_LENGTH = 6;
    public static final List<String> MESSAGE_TYPES = Arrays.asList("#UT", "OTI");

    public static Ticket decode(String contents, boolean isZxing) throws DataFormatException, ParseException {
        return decode(contents.getBytes(), isZxing);
    }

    public static Ticket decode(byte[] data, boolean isZxing) throws DataFormatException, ParseException {
        if (isZxing) {
            data = ZxingUtil.cleanupZXingData(data);
        }

        String contents = new String(data);

        Ticket s = new Ticket();
        s.setMessageType(contents.substring(0, 3));
        if (!MESSAGE_TYPES.contains(s.getMessageType().toUpperCase())) {
            throw new ParseException("Not a UIC ticket", 0);
        }
        s.setMessageTypeVersion(Integer.parseInt(contents.substring(3, 5)));
        s.setRicsCode(Integer.parseInt(contents.substring(5, 9)));
        s.setSignatureKeyId(contents.substring(9, 14));
        s.setSignature(contents.substring(14, 63));

        // Hack - the message length is encoded in a variety of ways apparently
        String messageLengthArea = contents.substring(61, 68);
        s.setMessageLength(Integer.valueOf(messageLengthArea.replaceAll("[^\\d.]", "")));

        s.setCompressedMessage(Arrays.copyOfRange(data, 68, data.length - 1));
        s.setMessage(decompress(s.getCompressedMessage(), s.getMessageLength() - 1));

        transformBlock(s, new String(s.getMessage()));

        return s;
    }

    private static byte[] decompress(byte[] bytesToDecompress, int numberOfBytesToDecompress) throws DataFormatException {
        Inflater inflater = new Inflater();
        inflater.setInput(bytesToDecompress, 0, numberOfBytesToDecompress);

        ArrayList<Byte> bytesDecompressedSoFar = new ArrayList<>();
        while (!inflater.needsInput()) {
            byte[] bytesDecompressedBuffer = new byte[numberOfBytesToDecompress];
            int numberOfBytesDecompressedThisTime = inflater.inflate(bytesDecompressedBuffer);
            for (int b = 0; b < numberOfBytesDecompressedThisTime; b++) {
                bytesDecompressedSoFar.add(bytesDecompressedBuffer[b]);
            }
        }

        byte[] returnValues;
        returnValues = new byte[bytesDecompressedSoFar.size()];
        for (int i = 0; i < returnValues.length; i++) {
            returnValues[i] = bytesDecompressedSoFar.get(i);
        }
        inflater.end();
        return returnValues;
    }

    static int parseHeader(Ticket s, String body, int offset) throws ParseException{
        s.getHeader().setVersion(Integer.valueOf(body.substring(offset, offset + 2)));
        s.getHeader().setLength(Integer.valueOf(body.substring(offset + 2, offset + 6)));
        s.getHeader().setCarrier(Integer.valueOf(body.substring(offset + 6, offset + 10)));
        s.getHeader().setOrderNumber(body.substring(offset + 10, offset + 30));

        String date = body.substring(offset+30,offset+42);
        s.getHeader().setCreationDate(sdf.parse(date).getTime());

        int flagsValue = Integer.valueOf(body.substring(offset + 42, offset + 43));
        s.getHeader().setFlags(TicketFlag.getFlagsFromNumber(flagsValue));

        s.getHeader().setLanguage(body.substring(offset+43,offset+45));
        s.getHeader().setLanguage2(body.substring(offset + 45, offset + 47));
        return offset+47;
    }

    static int parseFields(Ticket s, String body, int offset) throws ParseException {
        s.getContents().setVersion(getInteger(body, offset, 0, 2));
        s.getContents().setLength(getInteger(body, offset, 2, 6));
        s.getContents().setStandard(getString(body, offset, 6, 10));

        s.getContents().setNumberOfFields(getInteger(body, offset, 10, 14));

        offset += 14;
        // TODO: This could be read as a stream, meaning not trusting "numberOfFields"
        // TODO: Number of Fields could be wrong, white length is right
        for (int i = 0; i < s.getContents().getNumberOfFields(); i++) {
            if (body.substring(offset).contentEquals("")) {
                // TODO: Log - this actually might be an illegal ticket as number of fields is too big
                break;
            }

            TicketField f = new TicketField();
            f.setLine(getInteger(body, offset, 0, 2));
            f.setColumn(getInteger(body, offset, 2, 4));
            f.setHeight(getInteger(body, offset, 4, 6));
            f.setWidth(getInteger(body, offset, 6, 8));

            int format = getInteger(body, offset, 8, 9);
            f.setFormatting(Rct2Format.fromCode(format));

            // Ugly ugly hack for tickets that randomly use 2 places instead of 4
            Integer len = getInteger(body, offset, 9, 13);
            if (len > body.length()) {
                len = getInteger(body, offset, 9, 11);
                offset += 11;
            } else {
                offset += 13;
            }
            f.setLength(len);

            f.setText(getString(body, offset, 0, f.getLength()));
            offset += f.getLength();

            s.getContents().getFields().add(f);
        }

        return offset;
    }

    private static void transformBlock(Ticket s, String body) throws ParseException{
        int offset = 0;
        while (offset < body.length()){
            String type = body.substring(offset, offset + TICKET_BLOCK_NAME_LENGTH);
            if ("U_HEAD".equals(type)){
                offset = parseHeader(s, body, offset + TICKET_BLOCK_NAME_LENGTH);
            } else if ("U_TLAY".equals(type)){
                offset = parseFields(s, body, offset + TICKET_BLOCK_NAME_LENGTH);
            } else {
                // TODO: We should probably handle other blocks too, if they exist
                offset = parseFields(s, body, offset + TICKET_BLOCK_NAME_LENGTH);
                //break;
            }
        }
    }

    private static String getString(String body, int offset, int start, int end) {
        if (offset+end > body.length()) {
            throw new IllegalArgumentException("Reference to invalid field, data is too short");
        }
        return body.substring(offset + start, offset + end);
    }

    private static Integer getInteger(String body, int offset, int start, int end) {
        if (offset+end > body.length()) {
            throw new IllegalArgumentException("Reference to invalid field, data is too short");
        }
        String result = body.substring(offset + start, offset + end).replaceAll("[^\\d.]", "");
        return (!result.isEmpty()) ? Integer.valueOf(result) : 0;
    }

}

