package org.open918.lib;

import org.junit.Assert;
import org.junit.Test;
import org.open918.lib.domain.Ticket;

import java.text.ParseException;


/**
 * Created by Joel Haasnoot on 13/05/15.
 */
public class UicTicketParserTest {

    @Test
    public void testParseHeader() throws ParseException {
        String header = "U_HEAD0100531184           133012.002504201510086NLEN";
        Ticket s = new Ticket();
        int offset = UicTicketParser.parseHeader(s, header, 6);
        Assert.assertEquals("           133012.00", s.getHeader().getOrderNumber());
    }

}
