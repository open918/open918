package org.open918.lib.domain;

/**
 * Created by Joel Haasnoot on 26/04/15.
 */
public enum Rct2Format {

    DEFAULT(0),
    BOLD(1),
    ITALIC(2),
    BOLDITALIC(3),
    SMALL(4),
    SMALLBOLD(5),
    SMALLITALIC(6),
    SMALLBOLDITALIC(7);

    private final int code;

    Rct2Format(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Rct2Format fromCode(int format) {
        for (Rct2Format f : values()) {
            if (f.getCode() == format) {
                return f;
            }
        }
        return DEFAULT;
    }
}
