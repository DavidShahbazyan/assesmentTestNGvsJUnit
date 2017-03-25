package com.example.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author David.Shahbazyan
 * @since Mar 15, 2017
 */
@RunWith(Parameterized.class)
public class StringUtilsTest_JUnit {
    //default value = 0
    @Parameter(value = 0)
    public String s1;

    @Parameter(value = 1)
    public String s2;

    @Parameter(value = 2)
    public String delimiter;

    @Parameter(value = 3)
    public String expected;

    @Parameter(value = 4)
    public String[] expectedArray;

//    @Parameters(name = "{index}: testConcat(\"{0}\", \"{1}\", \"{2}\") = \"{3}\"")
    @Parameters
    public static Collection<Object[]> getConcatStrings() {
        return Arrays.asList(new Object[][]{
                {"a", "b", ", ", "a, b"},
                {"b", "c", " - ", "b - c"},
                {"c", "d", " : ", "c : d"},
                {"d", "e", " <=> ", "d <=> e"}
        });
    }

    @Parameters
    public static Object[][] getSplitStrings() {
        return new Object[][] {
                {"a, b", ", ", new String[] {"a", "b"}},
                {"b - c", " - ", new String[] {"b", "c"}},
                {"c : d", " : ", new String[] {"c", "d"}},
                {"d <=> e", " <=> ", new String[] {"d", "e"}}
        };
    }

    @Test
    public void testConcat() throws Exception {
        assertEquals(expected, StringUtils.concat(s1, s2, delimiter));
    }

    @Test
    public void testSplit() throws Exception {
        assertArrayEquals(expectedArray, StringUtils.split(s1, delimiter));
    }

}