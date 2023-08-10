package org.open918.lib.services;

import org.open918.lib.domain.Carrier;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joelhaasnoot on 18/11/2016.
 */
public class CarrierService {

    private final Map<Integer, Carrier> ricsCodeCarriers = new HashMap<>();

    public CarrierService() {
        InputStream in = CarrierService.class.getClassLoader().getResourceAsStream("uic_company_codes.csv");
        if (in != null) {
            for (String line : convertStreamToString(in).split("\\n")) {
                try {
                    String[] columns = line.trim().split(";");
                    if (!columns[0].replace("\uFEFF", "").equalsIgnoreCase("code")) { // Skip first line
                        int code = Integer.parseInt(columns[0]);
                        Carrier c = new Carrier(code, columns[1], columns[2],
                                (columns.length >= 4) ? columns[3] : null,
                                (columns.length == 5) ? columns[4] : null);
                        ricsCodeCarriers.put(c.getRics(), c);
                    }
                } catch (Exception e) {
                    System.out.println("Failed to parse line " + line);
                }
            }
            try {
                in.close();
            } catch (IOException ignore) {
            }
        }
    }

    private static String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public Carrier getCarrier(int ricsCode) {
        if (ricsCodeCarriers.containsKey(ricsCode)) {
            return ricsCodeCarriers.get(ricsCode);
        }
        return null;
    }
}
