package org.open918.lib.domain;

import org.junit.Test;
import org.open918.lib.domain.uic918_3.TicketFlag;

import java.util.EnumSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joel Haasnoot on 13/05/15.
 */
public class TicketFlagTest {

    @Test
    public void testGetFlagsFromNumber() throws Exception {
        assertEquals(TicketFlag.getFlagsFromNumber(0), EnumSet.noneOf(TicketFlag.class));
        assertEquals(TicketFlag.getFlagsFromNumber(2), EnumSet.of(TicketFlag.EDITED));
    }
}
