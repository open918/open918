package org.open918.lib.util;

/**
 * This cleans up an Aztec barcode as decoded by Zxing.
 * ZXing has a bug that produces incorrect byte data for Aztec barcodes
 * TODO: Check with latest version and determine if this was fixed
 */
public class ZxingUtil {

    public static byte[] cleanupZXingData(byte[] data) {
        byte[] out = data.clone();
        byte reducer = 0;
        int out_counter = 0;
        for (byte aData : data) {
            out[out_counter] = (byte) (aData + reducer);
            if (aData == (byte) 0xc3) {
                reducer = 0x40;
            } else if (aData == (byte) 0xc2) {
                reducer = 0;
            } else {
                reducer = 0;
                out_counter += 1;
            }
        }

        // Do substring of the byte array
        byte[] realout = new byte[out_counter];
        System.arraycopy(out, 0, realout, 0, out_counter);
        return realout;
    }
}
