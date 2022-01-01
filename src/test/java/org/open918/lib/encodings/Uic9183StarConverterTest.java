package org.open918.lib.encodings;

import org.junit.Test;
import org.open918.lib.TicketUtils;
import org.open918.lib.UicStarBlockParser;
import org.open918.lib.domain.Ticket;
import org.open918.lib.domain.TicketStandard;
import org.open918.lib.domain.uic918_3.Ticket918Dash3;

import java.text.ParseException;
import java.util.zip.DataFormatException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joel Haasnoot on 17/10/15.
 */
public class Uic9183StarConverterTest {

    @Test
    public void testMusterLanderticketSH() throws DataFormatException, ParseException {
        String ticket = "I1VUMDEwMDgwMDAwMDEwLQIUCcKvecOrwqYHw6nCkBoWw7glPjjDgTrDuRUKw7oCFQDCglQEw5nD\n" +
                "qBhaw4sWPXrDnsKaw5NIw4TDl8Oewqd3AAAAMDI1M3jCnFXCkMOPSsODQBDDhsK3wogIwp4Kwr3D\n" +
                "pCh6EWlgZnbCt8OZPRoTwohSRFhTexPCjMKhDcKWFmxKX8OBw5fDkjfDsMOeJ8Oxw6RMwrBQw6fC\n" +
                "ssODw6/Du8Omw5/ClsOPRX7CnQECWA3DoMKAwrzCmcKURWzDlEHCkAdLwoDChMOGeMOIw7IsF8Oj\n" +
                "bQYEwoDCjjnCgBfCksKOwpkQWcKmZFzDujTCvSM3TQ7DusOwwpTCkcO0w5nCvwlpw6fCtMOXCAFk\n" +
                "A8KywqHCmi/DqsO1wrbCmcOFw4VqwrFuw6tmGT82w5Vbw53CssKBw4dAw6fDlMKSw5zChG4qWMKM\n" +
                "IWbCinsZDScUKADCsRF1wrrCqcOmwpvDpcOsw6zDoX3DtVIzHMKJwowiJyzDu8Krw78hwrfCsMOk\n" +
                "wqTCssKrwrjDuMKrwpcDJ2XDt0/CpF7DucKYXk/CncOff0fDrcORT8K0HX4WasO4FSl1einDsGR3\n" +
                "w5wffMKow74vw7rCu03CnA==";

        Ticket s = TicketUtils.getTicket(ticket);
        assertEquals(s.getStandard(), TicketStandard.TICKET918_3);
        Ticket918Dash3 t = (Ticket918Dash3) s;
        assertEquals(3, t.getBlocks().size());
        assertEquals("0080ID", t.getBlocks().get(0).getType());
        assertEquals("0080BL", t.getBlocks().get(1).getType());
        assertEquals("0080VU", t.getBlocks().get(2).getType());
    }

    @Test
    public void testVDVContent() {
        UicStarBlockParser.decode(TicketUtils.fromBase64AsBytes("AGQAAAABAQAiTu+/vRh0A++/vRh3LO+/vUgALO+/vRgAAAooACJO77+9B++/vQUQE++/vQAQ"));

    }
}
