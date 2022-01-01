package org.open918.lib.domain;

import org.junit.Assert;
import org.junit.Test;
import org.open918.lib.Uic918Dash3TicketParser;
import org.open918.lib.domain.uic918_3.Ticket918Dash3;

import java.text.ParseException;


/**
 * Created by Joel Haasnoot on 13/05/15.
 */
public class UicTicketParserTest {

    @Test
    public void testParseHeader() throws ParseException {
        String header = "U_HEAD0100531184           133012.002504201510086NLEN";
        Ticket918Dash3 s = new Ticket918Dash3();
        Uic918Dash3TicketParser.parseHeader(s, header, 6);
        Assert.assertEquals("           133012.00", s.getHeader().getOrderNumber());
    }

}
