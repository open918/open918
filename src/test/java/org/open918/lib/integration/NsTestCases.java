package org.open918.lib.integration;

import org.junit.Assert;
import org.junit.Test;
import org.open918.lib.Keys;
import org.open918.lib.domain.uic918_3.Ticket918Dash3;
import org.open918.lib.signature.SignatureVerifier;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * Test cases for NS tickets
 * These (often acceptance environment) tickets were provided by NS during development of a UIC fork of this library
 */
public class NsTestCases extends TicketTestCase {

    @Test
    public void testNSEticketTestomgeving() {
        String ticket = "I1VUMDExMTg0TlNUMDIwLQIUesKuwqPCuTFCPz1Cw6/Ct1sZw5JSGMKXwpzDo8K7AhUAwoYyMsKS\n" +
                "wo8NPsOcTQgVw6bCu8KOT8Oawo/DqVsOAAAAMDI5MnjCnE1Rw4Fuw4IwDMO9wpVcekEaw5hJwpPC\n" +
                "psOHDjrCgcOEYMOqw5pKwpwQSMOWw4RAw63ClDLDtsO7c8Kywo7DsE5+wo7DvcO8w6w0w7tlWSwA\n" +
                "AcK0QsK0wqnCiMKQwrnDlRrCpwDCmCNIQMKDwqnCtmbCsy43w43Cvl4XO25KwrXCqsOmwrUEfsO2\n" +
                "ZcKAw6ovaMOJw516ckfDujl9DsKiw6zDjnQBw6QnBAMBw5ILwoLDssKhwprCr1pmw4bDi3nCnnob\n" +
                "w55Ow6hgw5jCmsKGKznDsQYYwpPDiMKWImMVL8KoQ8Kkw5tiwr1awojCl2rDuyokw4wQZsOewrzC\n" +
                "qMK3Dwx4GXYbwpTCoD1cw47DlB3Cv8OdBxjCpcOHNGTDj8O9cMOuw7svw4jDrsKlwqAnHsKQw4XC\n" +
                "qjFjwoxlIQx6EsOsw4N2w63CqmDDjsObw6XCuV9Ow4ZhScOhw5zDqXZIwpZEw65CXcKyecKfVU8d\n" +
                "XcKTcTAqwp3DnWXDisKmQmXDvAgbw4ZKM8OlG8KkwqDDv2/CjsOhw4okHMKdBsO+wqjDmMOJw7Yw\n" +
                "wo3CnXYyw6IXw6wUdsKi";

        Ticket918Dash3 t = (Ticket918Dash3) checkTicket(ticket);
    }

    @Test
    public void testNSIntTest() {
        String ticket = "I1VUMDExMTg0MDAwMDMwLAIUV8KOw43DiMO9L1V+XMODwovCh8ORHMO2w7bDtsKPV3cCFEVNw5BC\n" +
                "wrkkw6jCrF1uPMKUXwHDrcOPG8KpSmIAAAAAMDY0OXjDmlVUXW/DmzAMw7wrfMOewoBWw5TCl8Ot\n" +
                "wrwpwrHDqmhxw6RAcsOSwrUvRTFka8KKNQXDmsOsw7/Cj3RSwrtNwoAAPMKQw4cTwo/DjMO2YcOp\n" +
                "XS0Qw4Aow4RSw4PDtMKJwotdbsOmw6sHwoEFCinDkMKiEMOCw4TDtiZtH8O6w5bDnQlEwpQ2LXpJ\n" +
                "w4UICiTCoDYCQBvDp8Oiwq3Cvw/DjcOSwocawroNLH0PG8KfUhcpaR0iw6zCui7DgcOOwqc+w7kV\n" +
                "QVQJwooqQS3DgsKOIkvCscOmWA/CmsOQKEDDpATDukEqbm9dw44+ekrDpFJuCkbClsOXKAgpRwTD\n" +
                "lQwLwoonBCplwogewokTJcOzScK3w47CvU/CtVvDg8OiCiw3w7pKZ8KqwonDjsOOwpTCgcKSwosv\n" +
                "asO7ZgnCljDCpMOREMKZw5jCuBQyw4Quw5VgLXdFTkNJX8OLScKawpMgb2kWwrV3LSrChsKVIVjC\n" +
                "mcOGw7sIw516w57DuVXCiMONNcKJw5o2c8OfwrvClsKiD0skwrIaw4vCpMK2X8K6w7YuwpMcw65T\n" +
                "MFTCpMODw7PDqcOfw6EPwpTCsiDCjMOfRxXDtHxdwo3CisKFwpJQKn5lw4VxdR/Duk3Dq1zCn0nC\n" +
                "lxzDnxEDGcKWwrrClcKPKHAywqNxwrFBMVTCnzUIHCDDvGRgwr3DrWjDpnLDrD9fwqAZw4Jzw4XC\n" +
                "phHDhsOVBFXCo8Oqfjlfw5TDvQrCi2HDuMOnwqpQU8OIwo15NmDDgjAtI8Krw5E2LMOJDm1UJVHD\n" +
                "o8OZwrZzwoMcU8OOP8ORaMODZHogw5vCoVUsYVjDr8KSwrbCuChKTWXDjAfCmkFNSy5oT8KmbcKi\n" +
                "w40MEQs7wo0Owq8RwrUlT8KRXUXDvDZ9wrAYwqgsU1k+FzrClkLDqVE/worCmcOgM8OiwrXDo37C\n" +
                "qMKPw6/Ch8OjacO/dnw8HV7Cj8KPKFU5w7LDklnDrDpewpDClFExfsKxajgFwqIpwrHDkHLCpC4G\n" +
                "w6XCghdDw7I8ZXHCqcKfw7vDm8OwI8ODd0g+E8OiE8OvEQ55bMKyFMOzw5DCtmTDs0fCgsOrQxfD\n" +
                "kX7DssOqMkrDhSdwwrk+wr9Nw4APNsO6worClCg9HcOHw6bDrcOww7xOY8K3w6M7w6rCmGbCl8O/\n" +
                "EBDDgwXDszvCsMK6ScKww7jDu8O6w6tpw7/DtMO6w7LCssKHw7XDo8ObCQ11JH/CmMKpTMO7w5/C\n" +
                "s8KYQ8O8DwjDuMO4fQ==\n";

        Ticket918Dash3 t = (Ticket918Dash3) checkTicket(ticket);

    }

    @Test
    public void test33GroepsretourAmsterdamCRotterdamZuid() {
        String ticket = "I1VUMDExMTg0TlMwMDIwLQIUTsKCw5jDkFnCr3nDuRZewqzDo8OdRMOxBsKHwqvChH0CFQDCnHx/\n" +
                "dAZmw60SRMKhwrV5woXDlhLDknrCgcOlAQAAADAyNjV4wpxlUMOBbsKDMAzDvcKVwpw5wrR2Egd2\n" +
                "RMKUwq1owoxKDMKQwrpLwrXCqTl0UsOFFMOow7bDu8KLMwZoe8K5w7jDhX5Pw49uT8O7PMOdAQLC\n" +
                "kEJMwrTCmMKhdEzCpGkDIAlQAhoJBMKmKsOzwqo9NWV6w7QiLU3CnTXDksKPAADDngEqLiR0w5Z9\n" +
                "w7bDlsK9w5nCr8OLw7sgajvDtjfDhx5eYiBAw7rCh8KgwrhUWcOReWbDmMKPwrnDphzCnCcoPMOi\n" +
                "RztYJ8O2woDDix/CosKPNTNvw4J+FCrDqsOSwrLDmMKJw7vDusOwJMKkw5kCbjnCvGgOKwYGwrVP\n" +
                "G8KcdMOdwo/Co3XDp8OXwqt4wrldw45gFMO9wrZkeh3CplbCtsKBeMORw7xpLMKKf2Ymw7F7w6HC\n" +
                "jwjCksOVw5ZdwpHCosKieMOmeVvCozI8wpvChCvDhBvCtgPCmsKOwopUPcKLB8OXw5vCj8OBwoV7\n" +
                "wqJewonCoyhCwr3CiMKTaMOCNzIUcQI=";

        Ticket918Dash3 t = (Ticket918Dash3) checkTicket(ticket);

        try {
            Assert.assertTrue(SignatureVerifier.verify(Keys.NS002Key(), t));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }




}
