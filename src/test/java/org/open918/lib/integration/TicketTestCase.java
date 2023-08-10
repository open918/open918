package org.open918.lib.integration;

import org.junit.Assert;
import org.open918.lib.TicketUtils;
import org.open918.lib.domain.Ticket;

/**
 * Created by joelhaasnoot on 19/10/2016.
 */
abstract class TicketTestCase {

    protected Ticket checkTicket(String ticket) {
        try {
            Ticket s = TicketUtils.getTicket(ticket);
            if (s == null) {
                Assert.fail();
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return null;
    }
}
