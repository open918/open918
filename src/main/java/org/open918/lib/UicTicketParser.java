package org.open918.lib;

import org.open918.lib.domain.Ticket;
import org.open918.lib.domain.uic918_3.Ticket918Dash3;
import org.open918.lib.util.ZxingUtil;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.*;
import java.util.zip.DataFormatException;


public class UicTicketParser {

    // OTI is not as per UIC specifications, but is used by certain DB tickets that otherwise conform
    private static final List<String> MESSAGE_TYPES = Arrays.asList("#UT", "OTI");

    public static Ticket decode(String contents, boolean isZxing) throws DataFormatException, ParseException {
        return decode(contents.getBytes(), isZxing);
    }

    public static Ticket decode(byte[] data, boolean isZxing) throws DataFormatException, ParseException {
        if (isZxing) {
            data = ZxingUtil.cleanupZXingData(data);
        }

        String contents = new String(data, StandardCharsets.UTF_8);

        Ticket918Dash3 s;
        if (MESSAGE_TYPES.contains(contents.substring(0, 3).toUpperCase())) {
            s = Uic918Dash3TicketParser.parse(data);
        } else {
            // TODO: Uic918Dash2TicketParser
            s = null;
        }

        return s;
    }

}

