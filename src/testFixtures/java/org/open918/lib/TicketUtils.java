package org.open918.lib;

import org.open918.lib.domain.Ticket;
import org.open918.lib.domain.TicketStandard;
import org.open918.lib.domain.uic918_3.Ticket918Dash3;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.zip.DataFormatException;

import javax.xml.bind.DatatypeConverter;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joel Haasnoot on 17/10/15.
 */
public class TicketUtils {

    public static Ticket getTicket(String base64) throws DataFormatException, ParseException {
        return UicTicketParser.decode(fromBase64(base64), true);
    }

    public static Ticket918Dash3 getDash3Ticket(String base64) throws DataFormatException, ParseException {
        Ticket s = getTicket(base64);
        assertEquals(s.getStandard(), TicketStandard.TICKET918_3);
        return (Ticket918Dash3) s;
    }

    public static String fromBase64(String base64) {
        byte[] encodedHelloBytes = DatatypeConverter.parseBase64Binary(base64);
        return new String(encodedHelloBytes, StandardCharsets.UTF_8);
    }
    public static byte[] fromBase64AsBytes(String base64) {
        return DatatypeConverter.parseBase64Binary(base64);
    }

}
