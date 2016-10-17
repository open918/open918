package org.open918.lib.encodings;

import org.open918.lib.domain.GenericTicketDetails;
import org.open918.lib.domain.Ticket;
import org.open918.lib.TicketUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joel Haasnoot on 17/10/15.
 */
public class Rct2ConverterTest {

    @Test
    public void testToTicketDetailsNSEticket() throws Exception {
        String ticket = "I1VUMDExMTg0TlMwMDIwLAIUAkLCuRrDl8OEwr3Cv8K+w7HDgS/DuMOlT8O/Z8OXd8O0AhRONMOy\n" +
                "LQITwpBVw7zCvQ87Eis7wrnCh1jDg8O7AAAAADAyOTR4wpxdUV1rw4IwFMO9K3nDsUXCmMKewpvC\n" +
                "r8Kmwo9FOybCuDrCpBbDtiQdwoTDmcKtw6skworDu8O7wrvCqVrDhcKbEMOuw4nDjTk5N8OZbF/D\n" +
                "smwOAsKMInJaDGElwrRJw5UEIAsnecKVZGDCi2VebMK2w6Uye2fCkk7DlHpWSsKAJygFwqlzUsO5\n" +
                "cMO6w7XDocODw781XwfCkXfDn8K+BXHCiWDDkcKHw6RBUDFVwrNFw4XDiEbCucKIdcK0EcOtw7QM\n" +
                "w6bCuMKiw6nDvFPDnnzDrsKOw553YsO1wpYXwqDCoQwiw4gbYsK9KG3DusOMVMOZcjEXw4/Dq8OV\n" +
                "wqsATcKRTmMbwqJcw50hWMOSw6zCu1cyWcOodsO+R8OMfHcMdcOdw4Iqc8Ktw5lLwq3DssOtw57C\n" +
                "h304IhnCiDDDoxhIwobDo8OXHWsdw7dFwr3CgsKEwrvDq8K6WmTCjMK5w6s0wo0wfcK4esKUwoXD\n" +
                "kMKcw6rDkcOjwq3CpEwyaMOkwps1KRvDtcOdw7nDpSZwbMOKXMO/woHDusKXw7ciw7jDpkDDusKO\n" +
                "w4jDlkjDn8KIbnzCiX9BE34q";

        Ticket s = TicketUtils.getTicket(ticket);
        Rct2Converter converter = new Rct2Converter(s.getContents().getFields());
        GenericTicketDetails details = converter.toDetails();
        assertEquals("Vervoerbewijs Enkel", details.getTicketTitle());
        assertEquals("VALID FROM 01/09/2016 TO 01/09/2016", details.getValidity());
        assertEquals("Nine-Eighteen OPEN", details.getPassengerName());
        assertEquals("Arnhem Centraal", details.getOutwardDeparture());
        assertEquals("Arnhem Velperprt", details.getOutwardArrival());
        assertEquals("*****", details.getReturnDeparture());
        assertEquals("*****", details.getReturnArrival());
        assertEquals("EUR1.08", details.getPrice());
        assertEquals("  Enkele reis", details.getRouteDetails());
        assertEquals("2", details.getTravelClass());
    }

    @Test
    public void testToTicketDetailsNSInternational() throws Exception {
        String ticket = "I1VUMDExMTg0MDAwMDMwLAIUHMO7w48Aw6gDAsOHesKuw4PCszfDqsKwPGZhfsOxAhRHG2zDlB/D\n" +
                "gj7ChQzCjsK/w4Qmwoo5w7rCscOzVkgAAAAAMDM1MHjDmmVRw5FOw4MwDMO8wpXCvCABEsOITsKa\n" +
                "wqzDsMKWwq1ZF8KIWsKWZsKFwoHDkMKERDXCisOQQAzCicOfw4fDrhADwpEnw7t8wr7CnMOtw4Vq\n" +
                "w6ZsAQjCoBViwp7DjcOnF1fDs8Kbw4kKw4TDvsOhCEECGjzCo8KoCsOTwrhYwqVgwpfDlMKkJcOE\n" +
                "ScKSw4BlKRVIwokZJVh5wpdEw6lCw6FLw6ErwpFmNiwbVANDM0PDn8OWVcOhwqJIwrVrwoItf3FR\n" +
                "wrIYGgDDusKxScK2KsKswo3ChUg2ejdFNRQ1FzV5PhDCl3VMwr4qRRXDgMKYwpwsEUpFFjEUZ8Kc\n" +
                "ZTwYDMK6wqAYUBPDnxLDqcKMwqQ4R8OVwrrDmMOWLsKOw53CtcK/aAjCpQrCsAMwYx/CgkvCkHPC\n" +
                "sxpxw6/CqMO1wpbClnLDh8Kiw7fCscKuG8OHFsODw6E0HsOdIcOkw7nDvTE/VHovw68WUQzCqDwd\n" +
                "dsO1w4cIMRXCr8KSc33DtcOeP2/Dv1lFZnxrAcKKw7bDtcOlw7NhwrvDrTYdGMKlf3pdQ1bDgMOQ\n" +
                "BXDCtwTDmMK7w6PDsxLDjAPDoMKow6o3wp3Dq8OXTx9dwrcRw7VbwrfCoXvCqMOdw6LChi/Ch1l3\n" +
                "UcOZwr08w7bDq3PDgFNkw69ow4TCicOYJ18jBMKEXQ==";

        Ticket s = TicketUtils.getTicket(ticket);
        Rct2Converter converter = new Rct2Converter(s.getContents().getFields());
        GenericTicketDetails details = converter.toDetails();
        assertEquals("VERVOERBEWIJS", details.getTicketTitle());
        assertEquals("Geldig:01.12.2016 - 01.12.2016", details.getValidity());
        assertEquals("NineEighteen Open", details.getPassengerName());
        assertEquals("ROOSENDAAL", details.getOutwardDeparture());
        assertEquals("ESSEN", details.getOutwardArrival());
        assertEquals("", details.getReturnDeparture());
        assertEquals("", details.getReturnArrival());
        assertEquals("PrijsEUR      2.20", details.getPrice());
        assertEquals("STANDAARD TARIEFNIET GELDIG IN THALYS 100% KORTING NLZONDER TOESLAG GELDIG IN  ", details.getRouteDetails());
        assertEquals("2", details.getTravelClass());
    }
}