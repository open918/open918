package org.open918.lib.domain;

/**
 * Created by Joel Haasnoot on 26/04/15.
 */
public enum Carrier {

    EUROSTAR(19, "Eurostar"),
    DB(1180, "DB"),
    NS(1184, "NS"),
    DSB(1186, "DSB"),
    OBB(1181, "OBB"),
    SNCF(1187, "SNCF"),
    NMBS(1088, "NMBS"),
    UNKNOWN(0, "Unknown");

    private final int rics;
    private final String label;

    Carrier(int ricsCode, String label) {
        this.rics = ricsCode;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Carrier fromRics(int code) {
        for (Carrier c : values()) {
            if (c.rics == code) {
                return c;
            }
        }
        return UNKNOWN;
    }
}
