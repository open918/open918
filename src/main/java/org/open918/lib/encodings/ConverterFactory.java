package org.open918.lib.encodings;

import org.open918.lib.domain.uic918_3.TicketField;

import java.util.List;

/**
 * Created by Joel Haasnoot on 18/10/15.
 */
public class ConverterFactory {

    public static TicketConverter getInstance(String standard, List<TicketField> fields) {
        switch(standard) {
            case "RCT2": return new Rct2Converter(fields);
            case "EOSU": return new EosuConverter(fields);
            default: throw new IllegalArgumentException("Unknown standard");
        }
    }
}
