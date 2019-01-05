package org.open918.lib;

import org.open918.lib.domain.*;
import org.open918.lib.util.ZxingUtil;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

        try {
            tryParse(s, "UTF-8");
        } catch(Exception e) {
            // All kinds of bad things happen this way, but some tickets are encoded ASCII
            tryParse(s, "ASCII");
        }

        return s;
    }

    private static void tryParse(Ticket s, String charset) throws ParseException {
        transformBlocks(s, new String(s.getMessage(), Charset.forName(charset)));
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
        // TODO: Number of Fields could be wrong, while length is right
        for (int i = 0; i < s.getContents().getNumberOfFields(); i++) {
            System.out.println("Reading field "+i);
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
            System.out.println(f.getLine()+ " "+f.getColumn()+ " "+f.getHeight()+ " "+f.getWidth()+ " " + f.getLength() +" = "+f.getText());
            offset += f.getLength();


            s.getContents().getFields().add(f);
        }

        return offset;
    }

    private static void transformBlocks(Ticket s, String body) throws ParseException{
        int offset = 0;
        while (offset < body.length()){
            String type = body.substring(offset, offset + TICKET_BLOCK_NAME_LENGTH);
            switch (type) {
                case "U_HEAD":
                    offset = parseHeader(s, body, offset + TICKET_BLOCK_NAME_LENGTH);
                    break;
                case "U_TLAY":
                    offset = parseFields(s, body, offset + TICKET_BLOCK_NAME_LENGTH);
                    break;
                default:
                    offset = parseOtherBlock(s, type, body, offset + TICKET_BLOCK_NAME_LENGTH);
                    break;
            }
        }
    }

    /*
    Parse an unknown or custom block
     */
    private static int parseOtherBlock(Ticket s, String type, String body, int offset) {
        TicketBlock b = new TicketBlock();
        b.setType(type);
        b.setVersion(getInteger(body, offset, 0, 2));
        b.setLength(getInteger(body, offset, 2, 6));

        if (type.startsWith("0080")) {
            b.setLength(b.getLength() - 12); // It seems the header is subtracted from the body length...
        }

        b.setBody(getString(body, offset, 6, 6 + b.getLength()));
        s.getBlocks().add(b);

        // TODO: Add parsers for this
//        if (b.getType().equals("0080VU")) {
//            UicStarBlockParser.decode(b.getBody().getBytes());
//        }
        return offset + 6 + b.getLength();
    }

    private static String getString(String body, int offset, int start, int end) {
        // TODO: Record illegal argument if body.length?
        return body.substring(Math.min(offset + start, body.length()), Math.min(offset + end, body.length()));
    }

    private static Integer getInteger(String body, int offset, int start, int end) {
        String result = getString(body, offset, start, end).replaceAll("[^\\d.]", "");
        return (!result.isEmpty()) ? Integer.valueOf(result.replace(".0", "")) : 0;
    }

}

