package org.open918.lib;

import org.open918.lib.domain.Rct2Format;
import org.open918.lib.domain.uic918_3.*;
import org.open918.lib.util.Strings;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.zip.DataFormatException;

public class Uic918Dash3TicketParser {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmm");
    private static final int TICKET_BLOCK_NAME_LENGTH = 6;
    public static final String TICKET_HEAD = "U_HEAD";
    public static final String TICKET_FIELDS = "U_TLAY";

    public static Ticket918Dash3 parse(byte[] data) throws DataFormatException, ParseException {
        String contents = new String(data, StandardCharsets.UTF_8);
        Ticket918Dash3 ticket = new Ticket918Dash3();
        ticket.setMessageType(contents.substring(0, 3));
        ticket.setMessageTypeVersion(Integer.parseInt(contents.substring(3, 5)));
        ticket.setRicsCode(Integer.parseInt(contents.substring(5, 9)));
        ticket.setSignatureKeyId(contents.substring(9, 14));
        ticket.setSignature(Arrays.copyOfRange(data, 14, 64));

        decodeBody(data, contents, ticket);
        // Unfortunately, not all tickets conform to the UTF-8 encoding. This checks for a likely invalid ticket and tries again in ASCII
        // TODO might need to add more checks if a ticket is 'valid'
        if (ticket.getContents() == null || ticket.getContents().getFields().size() == 0) {
            decodeBody(data, new String(data, StandardCharsets.US_ASCII), ticket);
        }

        return ticket;
    }

    private static void decodeBody(byte[] data, String contents, Ticket918Dash3 ticket) throws DataFormatException, ParseException {
        // The message length is encoded in a variety of ways apparently, try to extract it
        try {
            ticket.setMessageLength(getMessageLength(contents.substring(61, 68)));
        } catch (Exception e) {
            ticket.setMessageLength(getMessageLength(new String(Arrays.copyOfRange(data, 61, 68))));
        }

        try {
            ticket.setCompressedMessage(Arrays.copyOfRange(data, 68, data.length));
            ticket.setMessage(Strings.decompress(ticket.getCompressedMessage(), ticket.getMessageLength()));
        } catch (Exception e) {
            // This is our fallback scenario
            ticket.setCompressedMessage(Arrays.copyOfRange(data, 68, data.length - 1));
            ticket.setMessage(Strings.decompress(ticket.getCompressedMessage(), ticket.getMessageLength() - 1));
        }

        transformBlock(ticket, new String(ticket.getMessage()));
    }

    private static Integer getMessageLength(String messageLengthArea) {
        return Integer.valueOf(messageLengthArea.replaceAll("[^\\d.]", ""));
    }


    public static int parseHeader(Ticket918Dash3 s, String body, int offset) throws ParseException {
        TicketHeader h = s.getHeader();
        h.setVersion(Strings.getInteger(body, offset, 0,6));
        h.setLength(Strings.getInteger(body, offset, 2,6));
        h.setCarrier(Strings.getInteger(body, offset, 6, 10));
        h.setOrderNumber(Strings.getString(body, offset,10, 30));

        h.setCreationDate(sdf.parse(Strings.getString(body, offset, 30,42)).getTime());
        h.setFlags(TicketFlag.getFlagsFromNumber(Strings.getInteger(body, offset, 42, 43)));

        h.setLanguage(Strings.getString(body, offset, 43,45));
        h.setLanguage2(Strings.getString(body, offset,  45, 47));
        return offset + 47;
    }

    static int parseFields(Ticket918Dash3 s, String body, int initialOffset, String type) throws ParseException {
        TicketContents contents = new TicketContents();
        int offset = initialOffset;
        contents.setType(type);
        contents.setVersion(Strings.getInteger(body, offset, 0, 2));
        contents.setLength(Strings.getInteger(body, offset, 2, 6));

        // This should be a safe offset, error if we go above this
        // Subtract 6 for type, and we should be fine again
        int maxOffset = initialOffset + contents.getLength() - 6;
        contents.setRawContents(body.substring(offset, maxOffset));

        // Anything past this point is disputable I think?
        contents.setStandard(Strings.getString(body, offset, 6, 10));
        contents.setNumberOfFields(Strings.getInteger(body, offset, 10, 14));

        try {
            offset += 14;
            // TODO: This could be read as a stream, meaning not trusting "numberOfFields"
            // TODO: Number of Fields could be wrong, while length is right
            for (int i = 0; i < contents.getNumberOfFields(); i++) {
                if (body.substring(offset).contentEquals("")) {
                    // TODO: Log - this is an incorrectly formatted ticket as number of fields is too big
                    break;
                }

                TicketField f = new TicketField();
                f.setLine(Strings.getInteger(body, offset, 0, 2));
                f.setColumn(Strings.getInteger(body, offset, 2, 4));
                f.setHeight(Strings.getInteger(body, offset, 4, 6));
                f.setWidth(Strings.getInteger(body, offset, 6, 8));

                int format = Strings.getInteger(body, offset, 8, 9);
                f.setFormatting(Rct2Format.fromCode(format));

                // Ugly ugly hack for tickets that randomly use 2 places instead of 4
                int len = Strings.getInteger(body, offset, 9, 13);
                if (len > body.length()) {
                    len = Strings.getInteger(body, offset, 9, 11);
                    offset += 11;
                } else {
                    offset += 13;
                }
                f.setLength(len);

                f.setText(Strings.getString(body, offset, 0, f.getLength()));
                // Ü seems to be counted as two characters with OEBB
                // TODO: See if also Ö and such are counted as two
                checkReplaceSpecialChar(body, offset, f, "\u00DC");
                checkReplaceSpecialChar(body, offset, f, "\u00FC");
                checkReplaceSpecialChar(body, offset, f, "\u00D6");
                checkReplaceSpecialChar(body, offset, f, "\u00F6");
                checkReplaceSpecialChar(body, offset, f, "\u00C4");
                checkReplaceSpecialChar(body, offset, f, "\u00E4");
                checkReplaceSpecialChar(body, offset, f, "\u00DF");

                offset += f.getLength();
                if (offset > maxOffset) {
                    throw new IllegalAccessException("We're past the point of no return, this must not be a block with ticket fields");
                }

                contents.getFields().add(f);
            }
        } catch (Exception e) {
            // TODO: What do we do here

        }
        // Add what we do have..
        if (type.contentEquals(TICKET_FIELDS)) {
            s.setContents(contents);
        } else {
            s.addBlock(type, contents);
        }
        // We continue with the length we were given
        return maxOffset;
    }

    private static void checkReplaceSpecialChar(String body, int offset, TicketField f, String special) {
        if (f.getText().contains(special)) {
            int count = f.getText().length() - f.getText().replace(special, "").length();
            // Do it again but with new length
            f.setLength(f.getLength() - count);
            f.setText(Strings.getString(body, offset, 0, f.getLength()));
        }
    }

    static void transformBlock(Ticket918Dash3 s, String body) throws ParseException{
        int offset = 0;
        while (offset < body.length()){
            try {
                String type = body.substring(offset, offset + TICKET_BLOCK_NAME_LENGTH);
                if (TICKET_HEAD.equals(type)){
                    offset = parseHeader(s, body, offset + TICKET_BLOCK_NAME_LENGTH);
                } else if (TICKET_FIELDS.equals(type)){
                    offset = parseFields(s, body, offset + TICKET_BLOCK_NAME_LENGTH, type);
                } else {
                    offset = parseFields(s, body, offset + TICKET_BLOCK_NAME_LENGTH, type);
                }
            } catch(Exception ignored) {
                break; // Otherwise we have an infinite loop.
            } // TODO: Log!
        }
    }
}
