package org.open918.lib.util;

import java.util.ArrayList;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Created by joelhaasnoot on 22/11/2016.
 */
public class Strings {

    public static String getString(String body, int offset, int start, int end) {
        if (offset+end > body.length()) {
            throw new IllegalArgumentException("Reference to invalid field, data is too short");
        }
        return body.substring(offset + start, offset + end);
    }

    public static Integer getInteger(String body, int offset, int start, int end) {
        if (offset+end > body.length()) {
            throw new IllegalArgumentException("Reference to invalid field, data is too short");
        }
        String result = body.substring(offset + start, offset + end).replaceAll("[^\\d.]", "");
        return (!result.isEmpty()) ? Integer.parseInt(result) : 0;
    }

    public static byte[] decompress(byte[] bytesToDecompress, int numberOfBytesToDecompress) throws DataFormatException {
        Inflater inflater = new Inflater();
        inflater.setInput(bytesToDecompress, 0, numberOfBytesToDecompress);

        ArrayList<Byte> bytesDecompressedSoFar = new ArrayList<>();
        while (!inflater.needsInput()) {
            byte[] bytesDecompressedBuffer = new byte[numberOfBytesToDecompress];
            int numberOfBytesDecompressedThisTime = inflater.inflate(bytesDecompressedBuffer);
            for (int b = 0; b < numberOfBytesDecompressedThisTime; b++) {
                bytesDecompressedSoFar.add(bytesDecompressedBuffer[b]);
            }
        }

        byte[] returnValues;
        returnValues = new byte[bytesDecompressedSoFar.size()];
        for (int i = 0; i < returnValues.length; i++) {
            returnValues[i] = bytesDecompressedSoFar.get(i);
        }
        inflater.end();
        return returnValues;
    }

}
