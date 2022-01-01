package org.open918.lib.integration;

import org.junit.Assert;
import org.junit.Test;
import org.open918.lib.domain.uic918_3.Ticket918Dash3;

/**
 * Test cases for NMBS tickets
 */
public class BeTestCases extends TicketTestCase {

    @Test
    public void test14DordrechtAntwerpen() {
        String ticket = "I1VUMDExMDg4MDAwMDIwLQIVAMKRw5jDt8O0wo4/w6RNMMKcFMOcwo48w5XClyrCmMODOAIUc8O7\n" +
                "wotHVS7CusO9w77CjsOAEirChsKnwqVlwr7CkFYAAAAwNDA4eMOadVLDr0/DmzAQw71Xw7wRwpDC\n" +
                "qMOuw7wjwqR8S1pDwrtmDnLDksKUwoFQwpVuXggKwonDlHTDsMOvw6/CrjDChibDrRQlfn53L8Ov\n" +
                "fF5vFzbCmQMCGMKFEMOHw6nDihfCt8OXwqstworCvyEvQElAwo3CoDTCusOsw4rCr8K3ZcKWfMKj\n" +
                "IhPDh35WSgApUUpFH8KjCcKYRQjCvcKgw6cQw7bCvxrCsWvCu8KncBBjw70cUH3DiirCmcOdwoVD\n" +
                "w53CtX0jwp4pw6VlGMO2wq91wo3DulPClmvCiWhCw7fCo21Ew5vCi8OHwqEJYx/CusOHwoASw4gV\n" +
                "GgBAwpNaZ8Kzw7XCrcOYWMK7wrJuwo7DilzCkD9FHCjCu8O2EEUxYWR8wqwzwrTDlsKMNHdNAsKK\n" +
                "wqR4A3UZw4bCg3Bfw5NCFG7ClsK+U8KsRC8Uw5XDkMK9w5bDoxjDukAbw5MPwqbCssK+w4rCrU/D\n" +
                "rWbDucKlwqBdYiBiw70oXWbCmS3DoWjDtsOdw5BsWUHDvMKGw7nCl8KqWibDv2JUwpolwrg5MDfD\n" +
                "u8O2acKESMKRaWRRwowSV27CrMK/wrFOwpzDnMOlw47CnkJEw6YRwqbCnD7CncOnfsOuw61sUcOy\n" +
                "UMO/w5MWwpoIPygffl4ew6ldwr3Dvz7CoGLCigxRw4RnFMOTCcKdwptif3QNaCXCr8OfwqZxKVBN\n" +
                "QE/DuG7CiHPCgcO6D8KgWmpHw7FpK8K8R8KMw7XCg8OPw7PCgsOmwpIkw5nDicKVP8K9w6dDf2DD\n" +
                "rcKzw59bwqTCnjo=";

        Ticket918Dash3 t = (Ticket918Dash3) checkTicket(ticket);
        Assert.assertEquals(t.getSignatureKeyId(), "00002");
    }

    @Test
    public void test15AntwerpenDordrecht() {
        String ticket = "I1VUMDExMDg4MDAwMDIwLAIUGhp1ZVjDqxAISC3DmcOxBU3Cs8OQwrcYwpLCiAIUcSkKD0TDoUnD\n" +
                "uwAhRk3DoRUkw6XDs8O2RwEAAAAAMDQwNnjDmnVSbU/DmzAQw74rw74ISMKrw67DvBJSwr4lwq3C\n" +
                "oV0zBzlpCkPCqEo3LwTChURqwrrDscO3d1cQwqsmccKKYj/Dt8Ocwp3Cn8OzecK9XcOYZA4IYBRC\n" +
                "HMKnK1/DnMOdwqzCtiDDvsKZwrwEJQE1woLDksOowrJrwr/DnsKWWXJPSSbCjsO9wqzClABSwqLC\n" +
                "lMKKFsKjCcKYRQjCvcKgw68Qw7bCvxvCsWvCu8OncBBjw70SUMKdRMKVw4zDrsOCwqHDrsOawr4R\n" +
                "LxTDsmcYw7bCr3XCjcO6JMOKwrVENMKhw7vDmTbCosOtw4XDk8OQwoTCsQ/DnVNACcKkCg0AwqBJ\n" +
                "wq3Cs8OZw7pObMKsXVk3R2UuScKfIg7ClF17wojCosKYMDI+w6YZw5prRsKawrvCpgLCikrCsQN1\n" +
                "GcOGwoNww5/DkkIUbsKWwr5TXMKJfijCqsKhe8Ktw4cxw7TCgRzDkw/CpsKywr7DisKtT8OtZsO5\n" +
                "wrUgLzEQccO9KF1mwpktw6Eow7Zdw5BsWUHDvMKGw7lIVS3Ck8O/MSrDjSXCuDkwwrfDu8O2ecKE\n" +
                "SMKxw6gpe8Kmw7PDnMOPwr3CnS1KwohINSIfwoVRw6LDisKNw7XCt8OWwonCs8OvwrnCs8OnPMOU\n" +
                "T8OaQhPDoQfDpcODwq/CqyPCvcKrw7c/BlRMwpEgwrLDuMKCbDrCoXtTwqzCj8KeAcOtw6TDjcOb\n" +
                "NMKuBMOiBMO0woTDn8KGw7hyAijCl8OaUXzDmwofw7jCgh99wp4XNMKXJMOJw47CrsO9w7kDYsKs\n" +
                "H8K5w7bDhV9WO8KeNA==";
        checkTicket(ticket);
    }


    @Test
    public void test16ArnhemKoeln() {
        String ticket = "I1VUMDExMDg4MDAwMDIwLAIUJngLw55VRhVwQMOgw5Z9d8KJdRDCiE/Cg8OdAhR2BcOGw5HCrjTD\n" +
                "l8K9w43DgQXDn8KDRW3Dmy3CgzPCmAAAAAAwMzY5eMOaXVFdT8OCQBDDvCvDt8KoTSTCu8O3UQsh\n" +
                "JG05wrDDmhbDksKWEsKfCMOgCRg+wpLCgsO6w7fDnUXCosOoPVw6wrPDncOZwpnCvcOJw6zDgcKG\n" +
                "fUAAwqMQwoJgME3Cs8KyH8OPUMO8HnkPSgJqaCvDhDwdFMKTWcKVwobDj8OUZCQUcSUBJMKiwpQK\n" +
                "wqQ0wprCgMKpXMOzwr5awrjDk3zCu8OZwq/DhMOOwp3DhMOHw6HDkHzDjsOnKMKBwpTCkMOGw5HC\n" +
                "ncKPwoosTMOHwoVNSlTDpsKew7QUw7HCoMOswqRAfcKFPcOPQ8OtI8OhwoBxw6BdDsO4fgBMwrMa\n" +
                "CxvDusOWwow0RwE0worCpsOIcxVFPUrCp2FZw5rDnBJuA37Ct0ESWxElaWorwqLCmMOmwpnCqGpb\n" +
                "w5QjW0R2wpo8wpZwdn1xEyc1w7k4Y8KewqXDqiTDvMKPUcOpNm/Ch8O/N8OjZsOzdgRfwpkfw6bD\n" +
                "qcOgwrZ7w7BpwqEIPjN+w5jDrMOXbsOHb0AGWAV1w6XCjifCkWdRKcOKPMKOw5Bww75Lwqlwwq/C\n" +
                "nRPClxfDs2Z5QMO1dzXDmsK0KMKyYkfCisKzKzl0w5vCl8ONSnQEwrRbwqBbw7zClMOiw64KUC8F\n" +
                "w5Aswq41w5nDr8KILmLCoHt2wrdzw41mwrnCvhk2wrddwp7DkMKzWcOmTW3DqcKNIsKvP8Oxw7pf\n" +
                "w4LChsKHEw==";

        checkTicket(ticket);
    }

    @Test
    public void test17AntwerpenSchiphol() {
        String ticket = "I1VUMDEwMDE5MDAwMDEwLAIUUh3CicO7Gi1cc8OqanfDocOIFsOmZ8KONUXDhwIUCsOUXXbDtMKZ\n" +
                "AUUIZAUNwrjCnwbDvXk9I8K6AAAAADAzMzF4w5pdUcOLbsKDQAzDvMKVPUdqasOvw4PDix7Ct8KE\n" +
                "wrbCqMKIRATCosOkFEUCwqlVH8KRKMONw7fDlybChVbDnQPDgsOjw4fDjMOYw43DsTHCiytAAGcA\n" +
                "MFRpwr7Cj8KZw7UWHDhrYXwJwqAGJDRGY1nDnFfDjcKxLsOiwoHCmxxCwpXDlhpAByDDkMKCSMK9\n" +
                "w4PDpMKWw79JGifChMKWwo7CgMOQAsKiZwBtVjzCqcKyUMObOsOWw7nCugQybkrDuWJdwq7CssKS\n" +
                "UzfCm1jCplXDnALCscK6f8ODXcO4woMswpnCjMOITwjDi03DmBLDgmjDgAbCtMKBAUlrAXTCtsKF\n" +
                "RMKLOCMhfywkwobCpljCk0bDo8OcwpzDjsKaCg3CiQDCkQd+wrFwYcOJw5PCnQnDs8OEfMKHw44i\n" +
                "wodBw4LDsMK7QC3DijHDuVnCo8KKwqvCpsKow5EjwpfCoh7ClXLDn1RMLMORwo7Ci8OjR3fCh03C\n" +
                "tsKPw6gdw43DkMO1OsOMw4zCq0ZhQjzCtV9vwoMawrrDj8OhBBrDhcOTwpVrw5fDtcKXc8OXwrcg\n" +
                "wronMMONd0rCrjzCssOwOcOFwp15OCkDw6rDvcOlQ13DjsOnXj13woPCunTDvcOQd8KvwqoVwqBF\n" +
                "TzQbTcOjN8OIw6h+wrw=";

        checkTicket(ticket);
    }

    @Test
    public void test18EurostarHeenreis() {
        String ticket = "I1VUMDEwMDE5MDAwMDEwLAIUUh3CicO7Gi1cc8OqanfDocOIFsOmZ8KONUXDhwIUCsOUXXbDtMKZ\n" +
                "AUUIZAUNwrjCnwbDvXk9I8K6AAAAADAzMzF4w5pdUcOLbsKDQAzDvMKVPUdqasOvw4PDix7Ct8KE\n" +
                "wrbCqMKIRATCosOkFEUCwqlVH8KRKMONw7fDlybChVbDnQPDgsOjw4fDjMOYw43DsTHCiytAAGcA\n" +
                "MFRpwr7Cj8KZw7UWHDhrYXwJwqAGJDRGY1nDnFfDjcKxLsOiwoHCmxxCwpXDlhpAByDDkMKCSMK9\n" +
                "w4PDpMKWw79JGifChMKWwo7CgMOQAsKiZwBtVjzCqcKyUMObOsOWw7nCugQybkrDuWJdwq7CssKS\n" +
                "UzfCm1jCplXDnALCscK6f8ODXcO4woMswpnCjMOITwjDi03DmBLDgmjDgAbCtMKBAUlrAXTCtsKF\n" +
                "RMKLOCMhfywkwobCpljCk0bDo8OcwpzDjsKaCg3CiQDCkQd+wrFwYcOJw5PCnQnDs8OEfMKHw44i\n" +
                "wodBw4LDsMK7QC3DijHDuVnCo8KKwqvCpsKow5EjwpfCoh7ClXLDn1RMLMORwo7Ci8OjR3fCh03C\n" +
                "tsKPw6gdw43DkMO1OsOMw4zCq0ZhQjzCtV9vwoMawrrDj8OhBBrDhcOTwpVrw5fDtcKXc8OXwrcg\n" +
                "wronMMONd0rCrjzCssOwOcOFwp15OCkDw6rDvcOlQ13DjsOnXj13woPCunTDvcOQd8KvwqoVwqBF\n" +
                "TzQbTcOjN8OIw6h+wrw=";

        checkTicket(ticket);
    }

    @Test
    public void test18EurostarTerugreis() {
        String ticket = "I1VUMDEwMDE5MDAwMDEwLAIUZGt/eMKGLnfDlsKIVSbDiWtxb1fDgWohw5UCFDExLEc8wr8BNMKp\n" +
                "w6DDnMKawo8VOXtQVcKowooAAAAAMDMzM3jDml1RTW/DgjAMw70rOSPCjcOZScKcNMOHUMK6UcKt\n" +
                "KsKowrTCiMKdEFIrbcOaB1LDl8Oxw7tnFwrDknzCiMOiw6c4w689wrs5wqzCssK4BAQgA8KAwqFK\n" +
                "w7N9w4zCrMK3QEBEMEYCwqgBHRrCo8KxLMKewqrDplAXw7HClcKbCMKhSmsNwqADOMOQwoLDiHvD\n" +
                "ksOmwpHDr04awq8IwoY5WHBoAcORM8KAwr5YwpfDi8KsVMObw7phE8OLwrTCiltwwobCpsKqw43C\n" +
                "ihdVFlzCjXXCvi7DgcKxwrp/wp9TwrgjesOOVMOOw7kJYcK5CVtCwqbDpMKwAcKJwrXCoMKUwrUA\n" +
                "OsObQsKiRcKcwpHClA/CgsOEwrgpw5cew5HCsMO3wqnCnDUVGicCRBvDuMOZwozDmA0gwplww7sx\n" +
                "w58hWcOkNEgaw64Dw5TCohzCk8OrGFVcNkXCjUzDgMKgHsKVcsOfw7RYwrNEOw7CjsODLVbCm2wf\n" +
                "w5HCk8K7QcKXw60wM8KPGsKFCcOxw5jDvn4OasOofsKGI2gUTxfCrl3Dl8KfT13Dn8KCw6jCnsOA\n" +
                "NMOfKcOZw7LDiMOCw6sUd8Omw7nCqAzCqMKvw7dvdT7CnXrDtcOWDcOqw5zDtUPDn33CqFbCgBbC\n" +
                "vXM3wqNpw7wDwq5nfsKd";

        checkTicket(ticket);
    }



}
