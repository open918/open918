package org.open918.lib.domain;

/**
 * Created by Joel Haasnoot on 26/04/15.
 */
public class Carrier {

    private final int rics;
    private final String labelShort;
    private final String labelLong;
    private final String country;
    private final String website;

    public Carrier(int rics, String labelShort, String labelLong, String country, String website) {
        this.rics = rics;
        this.labelShort = labelShort;
        this.labelLong = labelLong;
        this.country = country;
        this.website = website;
    }

    public int getRics() {
        return rics;
    }

    public String getLabelShort() {
        return labelShort;
    }

    public String getLabelLong() {
        return labelLong;
    }

    public String getCountry() {
        return country;
    }

    public String getWebsite() {
        return website;
    }
}
