package org.open918.lib.encodings;

import org.open918.lib.domain.GenericTicketDetails;
import org.open918.lib.domain.uic918_3.Ticket918Dash3;
import org.open918.lib.TicketUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joel Haasnoot on 17/10/15.
 */
public class Rct2ConverterTest {

    @Test
    public void testNSEticket2016() throws Exception {
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

        Ticket918Dash3 s = TicketUtils.getDash3Ticket(ticket);
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
    public void testNSInternational2016() throws Exception {
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

        Ticket918Dash3 s = TicketUtils.getDash3Ticket(ticket);
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

    @Test
    public void testNSSingleEticket2018() throws Exception {
        String ticket = "I1VUMDExMTg0TlMwMDIwLAIUFld/VMOMKnsJwq18WcOvw5LCkQ48w6TCucOMAgIUV8O3w5jDrDUt\n" +
                "e8OYwoI+wpTDkTrDkXjDkcKgOgXCjQAAAAAwMjk1eMKcXVBda8OCQBDDvCvDt8OiwovDkMK6e1/C\n" +
                "uTwGTcKpwpDDhiJJw4AnSWHCqWltKsKnw5jCv8Ofwr1TY3ATw4hOw6ZmbnbDq8Ota8KeLQABwoxC\n" +
                "dFoMBcKAwolRVsKiwpMAWgJ/UUtbFnlZb8KrIsObwrBIJ2o9wq/CmMOnFzAFVMKXwqYhf8O+JcO/\n" +
                "QX/DncOXUcOkw703w60BwplCwrAQS8OywoPCoELCq8Omw4vChsKRDXYBw6sQI8OEwokKw5bCuMKy\n" +
                "w6vDqSnDrz53J8KiXsKsw57DsxJwwqABEcOkHcKxX8KwNsKxM01WLBfDomXCvXoTEmfCoGdhDFHC\n" +
                "rUYILGrDjh3CnUzDpsO7HcO9wog5w7Unw5/CtnvCsMOKw5w4e8OlGsOaH8OIH8O8CcKSQQhmGgrC\n" +
                "ksOhw7jDrcKPwrXCjsOnw4LDqCDDgcKNwqZuwpYZY8KeOk0DTB/CrsKeZMOed8OndsOyeCsqwpMM\n" +
                "HnnCvUZlwoPCv8K7bMOuwpl7DRxCJ3EzccOzJDx1R8OUIyFHQ30XwrrDqcK1w74BPjp+Jw==";

        Ticket918Dash3 s = TicketUtils.getDash3Ticket(ticket);
        Rct2Converter converter = new Rct2Converter(s.getContents().getFields());
        GenericTicketDetails details = converter.toDetails();
        assertEquals("Vervoerbewijs Enkel", details.getTicketTitle());
        assertEquals("VALID FROM 21/04/2018 TO 21/04/2018", details.getValidity());
        assertEquals("Nine-Eighteen OPEN", details.getPassengerName());
        assertEquals("Arnhem Centraal", details.getOutwardDeparture());
        assertEquals("Arnhem Velperprt", details.getOutwardArrival());
        assertEquals("*****", details.getReturnDeparture());
        assertEquals("*****", details.getReturnArrival());
        assertEquals("EUR1.10", details.getPrice());
        assertEquals("  Enkele reis", details.getRouteDetails());
        assertEquals("2", details.getTravelClass());
    }

    @Test
    public void testNSRailRunnerEticket2018() throws Exception {
        String ticket = "I1VUMDExMTg0TlMwMDIwLQIUPMOkGcOLL8ONw7kSwoDDonAmNBTDvsKFwrFqAsKlAhUAwqTDtAfD\n" +
                "lMKAdg0SHzFPEsKdw6lqWMOswpzDvBkAAAAwMjcweMKcfVBNa8ODMAzDvSs+B8K2SsO+wop7DMKN\n" +
                "w4cywrJkwoQkwrBTw4nDgHRewosLbsK2w73DvcOZZsKkOUU2QsKPwqfDt8KQNBzCn3VRAgIIwobC\n" +
                "qDhZAgBzw4Ekw4U9BcOgFFBRw6RMNsK1bsKGY18Xw69Bw4QFw60OfcOgw4MHw5wDwrJYUDoaw79z\n" +
                "NcO+w4PDvMOawq8bKcKnw5N5wprDvAwYWAQJKWh4CCzClsOsUMKNAcOJw6gYMcKPwpPDhMKJwpIi\n" +
                "wrY2w5bCmQdtT8KfwrMxwo7CvHjDksK+acOAwqUBEMKBw55RcMKMw6YiVWIsw6rCqiRPXcO7SijD\n" +
                "rsKAw6/Doi7CpG9XCCTDsjB8csOKw7XDpUxuw7M0w5vCqyPDlsKRwqYGw4nDhAbCm29qw7NNwq3C\n" +
                "lCoswo3CicOOQMKtTjJWBTLCkS9YDx0yGXtVOhF9DMK+HGLDisKjGsK6w4lew7zCt3PDhiNfw6nC\n" +
                "sixDfsOXwqnDrD/DvgBSwr14w5s=";

        Ticket918Dash3 s = TicketUtils.getDash3Ticket(ticket);
        Rct2Converter converter = new Rct2Converter(s.getContents().getFields());
        GenericTicketDetails details = converter.toDetails();
        assertEquals("Vervoerbewijs Dagkaart", details.getTicketTitle());
        assertEquals("VALID FROM 21/04/2018 TO 21/04/2018", details.getValidity());
        assertEquals("Nine-Eighteen Jr OPE", details.getPassengerName());
        assertEquals("Elk station in NL", details.getOutwardDeparture());
        assertEquals("Elk station in NL", details.getOutwardArrival());
        assertEquals("Elk station in NL", details.getReturnDeparture());
        assertEquals("Elk station in NL", details.getReturnArrival());
        assertEquals("EUR2.50", details.getPrice());
        assertEquals("  Railrunner", details.getRouteDetails());
        assertEquals("*", details.getTravelClass());
    }

    @Test
    public void testTranzerArrivaEticket2018() throws Exception {
        String ticket = "I1VUMDE4OTk5Q1hYMDEwLQIVAMKLKcKhwosbUhbDr8O3an3CgwFwbsKnesO3SzICFG4Lw7nDj3NO\n" +
                "wqlOw7vCsMKgcMK2ZsOJMcOxLFnCuQAAADAyODl4wpxlwpFNb8OCMAzChsO/Si5cOAw7XyTDhwg6\n" +
                "w5HCqcKjUlcqw63ChMKYFGlswozCosKAw5jDn8KfHUFhwptVwqnCtsOTw7fDscOrdMK1XhRhDghg\n" +
                "wpTDs8OewotfwoEewpUECcKgJcKgwqPCt8KTw4vCqljCrsOWbRVeScKkwq1vZi3DtcOpAcO0w4Bf\n" +
                "U8KCw4XDvjPDrsKiSHF7BMKkFsKCwoUcDENQwpzCqlnDmVFlGcODwrXDpsOxbCMrWMOzJBYhwrws\n" +
                "w6vCugUcw5pEB3nCq8KIw4NIwpMzw5PChcKqwpzCi8OHwqZ+FhInwqAnbFvCtMO1XQUWNcO5w4wk\n" +
                "E8OSw749fsKJWcOcwp/DkmbCswPCq8OMw7XDjF3DjsK6wrg7w4R0w6jDu3TCgsOpIAUzw6bCgMOp\n" +
                "IMK4dsKsdWQdM0PCgsK7w5vCtysDw5XCtC/Crwkaw78MH8KFwpTCtsOnw43DqMO/XFRmOlDCilXC\n" +
                "g8OKw7IEwpdvDR8ow5dgwq53w6/Cu8KYw459TG/DsXvDu3EUw7lPwqDCvgPCkEnDlDfCgBtfw6IH\n" +
                "OcKvfEA=";

        Ticket918Dash3 s = TicketUtils.getDash3Ticket(ticket);
        Rct2Converter converter = new Rct2Converter(s.getContents().getFields());
        GenericTicketDetails details = converter.toDetails();
        assertEquals("Enkele reis", details.getTicketTitle());
        assertEquals("VALID FROM 21/04/2018 TO 21/04/2018", details.getValidity());
        assertEquals("J HAASNOOT", details.getPassengerName());
        assertEquals("Arnhem Centraal", details.getOutwardDeparture());
        assertEquals("Arnhem Velperpoort", details.getOutwardArrival());
        assertEquals("*****", details.getReturnDeparture());
        assertEquals("*****", details.getReturnArrival());
        assertEquals("EUR1.10", details.getPrice());
        assertEquals("  Vervoerbewijs Enkel", details.getRouteDetails());
        assertEquals("2", details.getTravelClass());
    }

    @Test
    public void testArrivaEticket2018() throws Exception {
        String ticket = "I1VUMDEzMDk1MDAwMDEwLQIUesObw5jCvRrCtsKww4jCiMKFVMOsw5kWwr1fasOOc8KyAhUAwo0Q\n" +
                "acOqwqvDkMOUFEHDph9rfSIHwobDrcOcFMK6AAAAMDIwNnjDmlVOw5HCisOCMBDDvMKVw7zCgDJJ\n" +
                "wprCtHkMNcOgQy8twr0qw5zCk8KIwrdcBS/ClcOQw7/Dh8ONwqHDiMOtw4vDrMOsw4wsczjDrcKD\n" +
                "w59BAkZrOMKjwqRUDsOiw58owqACZMKjwqA0YhfDosOhNHXDvsKLQ8KqcmM7wrEOw4cGB8Kpw4vC\n" +
                "rsKtw49pwqZfw5FSWsOzw7l8ExvDscK8HMOpdsKnfF/ClsK8QkNBGsO2wpdHcsKLasOLwrwpRSAL\n" +
                "QsKZHcKJwpkowot+CFHDhGvConDDvcKZV8Kiw4TDgcKXwovCgcKdbwZYWTHCqwsxfsKMw7vDsCHD\n" +
                "mhDCp8ORw7sOVsKbwpfDljzCtWPDqMKGMA59P07CsMK2w6YPf8Klw6wnXcKWw7TCjcO6fcOCA0J/\n" +
                "ScO9";

        Ticket918Dash3 s = TicketUtils.getDash3Ticket(ticket);
        Rct2Converter converter = new Rct2Converter(s.getContents().getFields());
        GenericTicketDetails details = converter.toDetails();
        assertEquals("Arnhem Centraal - Arnhem Velperpoort", details.getTicketTitle());
        assertEquals("", details.getValidity());
        // TODO: Fix this
        assertEquals("Arnhem Centraal - Arnhem VelperpoortDe heer OPEN NineEighteen", details.getPassengerName());
        assertEquals("ARNHEM CENTRAAL", details.getOutwardDeparture());
        assertEquals("ARNHEM VELPERPOORT", details.getOutwardArrival());
        assertEquals("", details.getReturnDeparture());
        assertEquals("", details.getReturnArrival());
        assertEquals("", details.getPrice());
        assertEquals("  ", details.getRouteDetails());
        assertEquals("Second", details.getTravelClass());
    }
}
