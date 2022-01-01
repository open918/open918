package org.open918.lib;

public class Keys {

    public static String wrapCert(String base64) {
        return "-----BEGIN CERTIFICATE-----\n" + base64 + "\n-----END CERTIFICATE-----";
    }

    public static String NS003Key() {
        String key = "MIIDKjCCAuigAwIBAgIEUx8inDALBgcqhkjOOAQDBQAweDELMAkGA1UEBhMCQkUxEDAOBgNVBAgTB0JyYWJhbnQxETAPBgNVBAcTCEJydXNzZWxzMRAwDgYDVQQKEwdTeW50aWdvMRQwEgYDVQQLEwtEZXZlbG9wbWVudDEcMBoGA1UEAxMTUGFzc2VuZ2VyIFNvbHV0aW9uczAeFw0xNDAzMTExNDUwMDRaFw0xNzA3MDExNDUwMDRaMHgxCzAJBgNVBAYTAkJFMRAwDgYDVQQIEwdCcmFiYW50MREwDwYDVQQHEwhCcnVzc2VsczEQMA4GA1UEChMHU3ludGlnbzEUMBIGA1UECxMLRGV2ZWxvcG1lbnQxHDAaBgNVBAMTE1Bhc3NlbmdlciBTb2x1dGlvbnMwggG4MIIBLAYHKoZIzjgEATCCAR8CgYEA/X9TgR11EilS30qcLuzk5/YRt1I870QAwx4/gLZRJmlFXUAiUftZPY1Y+r/F9bow9subVWzXgTuAHTRv8mZgt2uZUKWkn5/oBHsQIsJPu6nX/rfGG/g7V+fGqKYVDwT7g/bTxR7DAjVUE1oWkTL2dfOuK2HXKu/yIgMZndFIAccCFQCXYFCPFSMLzLKSuYKi64QL8Fgc9QKBgQD34aCF1ps93su8q1w2uFe5eZSvu/o66oL5V0wLPQeCZ1FZV4661FlP5nEHEIGAtEkWcSPoTCgWE7fPCTKMyKbhPBZ6i1R8jSjgo64eK7OmdZFuo38L+iE1YvH7YnoBJDvMpPG+qFGQiaiD3+Fa5Z8GkotmXoB7VSVkAUw7/s9JKgOBhQACgYEAp3ahr0Hmd3MEBuHUSBU5BpUrmXu5kxXvmnqmCpmvHNFasTvFnCgc8QTVd51/M715PrS/XICCLUei1bTlA1jdMFOsyuo0ot6HJ3gcrN+BOnB889oKyDTh1nIBPt3hIHf274EV3boX03tf5RRyFvYV5ZQLLd/byQK/2UtO3AldIOQwCwYHKoZIzjgEAwUAAy8AMCwCFHzLxsKw0mb0ydN9c3eS4x7igxe4AhQa3/+DS+UwXvcbWnZia7kVogkKZw==";
        return wrapCert(key);
    }

    // 1184 - NS002 (Prod)
    public static String NS002Key() {
        String key = "MIID0zCCA5OgAwIBAgIJAJ09f3Y6kCnjMAkGByqGSM44BAMwgaMxCzAJBgNVBAYT\n" +
                "Ak5MMRAwDgYDVQQIDAdVdHJlY2h0MRAwDgYDVQQHDAdVdHJlY2h0MRUwEwYDVQQK\n" +
                "DAxOUyBSZWl6aWdlcnMxGjAYBgNVBAsMEUJ1c2luZXNzIFN5c3RlbWVuMRowGAYD\n" +
                "VQQDDBFFdGlja2V0IHByb2R1Y3RpZTEhMB8GCSqGSIb3DQEJARYSbnNjLmludGVy\n" +
                "bmV0QG5zLm5sMB4XDTE0MDEwODA3MjcyM1oXDTI0MDEwNjA3MjcyM1owgaMxCzAJ\n" +
                "BgNVBAYTAk5MMRAwDgYDVQQIDAdVdHJlY2h0MRAwDgYDVQQHDAdVdHJlY2h0MRUw\n" +
                "EwYDVQQKDAxOUyBSZWl6aWdlcnMxGjAYBgNVBAsMEUJ1c2luZXNzIFN5c3RlbWVu\n" +
                "MRowGAYDVQQDDBFFdGlja2V0IHByb2R1Y3RpZTEhMB8GCSqGSIb3DQEJARYSbnNj\n" +
                "LmludGVybmV0QG5zLm5sMIIBtjCCASsGByqGSM44BAEwggEeAoGBAO03OW4DOP8/\n" +
                "KQj9FADbhMysF6sd3TYxWPRpJ4pHbjl5/ogHx2yGVhZ7rEUj2YUqPWKwim2nDOum\n" +
                "gqSQfDnOZc9z3Wrj2cR0hyqtRTF5Qk1gyc+Q00Q0QyHd3XKfnc3NHoE+7Dsxoxm9\n" +
                "FO5zY0BSA3zt7JnO5pxnXVtkDj5IXjXRAhUAqCl7L9zECf9siJGoCzjo1K0HNLcC\n" +
                "gYAOm6Dr4ITWCEL1ABU78/FTFbetQSqA42E6bADy69knRlW1Vh4fzex/DbzXI9xU\n" +
                "431dj/NrLyTmOygyJWGJR7VI5o96UbRFe1vqfE13mxTc9VlYRHketVMlrP54Mo20\n" +
                "hijLvJWHlWj54OhqVGNUV8Mj29PYfE2KYq7EOXUIK6oMxQOBhAACgYBVmRP9ZruJ\n" +
                "9frYGZy/Das70KcQhe9G79ifjhxjjAgiBzegqlv92IKaQl7ai2XhKfxFRQSSnsYI\n" +
                "8TcW7ARrYJP4eddyr2WNk594uaASE8X54PIekcToAMC/vI9ZI2/T4lHXmn4d/5zE\n" +
                "XyxDxyIF6gtnXUsrjyVXAYiw3Y3Tx+ldnKNQME4wHQYDVR0OBBYEFIBmg4W69s09\n" +
                "i8N1qyXyd1RPvsewMB8GA1UdIwQYMBaAFIBmg4W69s09i8N1qyXyd1RPvsewMAwG\n" +
                "A1UdEwQFMAMBAf8wCQYHKoZIzjgEAwMvADAsAhQ8xUvztzfGu24cJm+mgmPuxbA9\n" +
                "iAIUOqTpCO+e4He8b+7bT+laaQ+kkL8=";
        return wrapCert(key);
    }
}
