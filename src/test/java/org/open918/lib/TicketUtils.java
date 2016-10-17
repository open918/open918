package org.open918.lib;

import org.open918.lib.UicTicketParser;
import org.open918.lib.domain.Ticket;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.zip.DataFormatException;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by Joel Haasnoot on 17/10/15.
 */
public class TicketUtils {

    public static Ticket getTicket(String base64) throws DataFormatException, ParseException {
        byte[] encodedHelloBytes = DatatypeConverter.parseBase64Binary(base64);
        String decodedBase64 = new String(encodedHelloBytes, StandardCharsets.UTF_8) ;

        return UicTicketParser.decode(decodedBase64, true);
    }
}
