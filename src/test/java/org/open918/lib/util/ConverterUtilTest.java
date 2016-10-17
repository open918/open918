package org.open918.lib.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joel Haasnoot on 17/10/15.
 */
public class ConverterUtilTest {

    @Test
    public void testIsBetween() throws Exception {
        // Test cases thanks to "Constraint Propagation Algorithms for Temporal Reasoning"
        // http://www.aaai.org/Papers/AAAI/1986/AAAI86-063.pdf

        // 'Option' contains/during 'target
        assertTrue(ConverterUtil.isBetween(2, 3, 1, 5));

        // 'Option' before 'target'
        assertFalse(ConverterUtil.isBetween(1, 2, 3, 4));

        // 'Option' after 'target'
        assertFalse(ConverterUtil.isBetween(3, 4, 1, 2));

        // 'Option' meets 'target'
        assertTrue(ConverterUtil.isBetween(1, 2, 2, 3));

        // 'Option' overlaps start of 'target
        assertTrue(ConverterUtil.isBetween(1, 4, 2, 5));

        // 'Option' overlaps end of 'target
        assertTrue(ConverterUtil.isBetween(4, 6, 2, 5));

        // 'Option' equal to 'target
        assertTrue(ConverterUtil.isBetween(1, 5, 1, 5));

        // 'Option' starts 'target
        assertTrue(ConverterUtil.isBetween(1, 2, 1, 5));

        // 'Option' ends 'target
        assertTrue(ConverterUtil.isBetween(4, 5, 1, 5));

        // 'Option' dwarfs 'target
        assertTrue(ConverterUtil.isBetween(1, 5, 2, 3));
    }
}