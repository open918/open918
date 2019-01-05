package org.open918.lib;

import org.open918.lib.domain.*;
import org.open918.lib.util.ZxingUtil;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Created by Joel Haasnoot on 22/04/15.
 *
 */

public class UicStarBlockParser {

    public static void decode(byte[] contents)  {
        int terminalnummer = getInt(contents, 0);
        int persons = contents[5];
        int products = contents[6];
        System.out.print(persons);
    }

    private static int getInt(byte[] arr, int off) {
        return arr[off]<<8 &0xFF00 | arr[off+1]&0xFF;
    }
}

