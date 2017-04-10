package com.example.helper;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author David.Shahbazyan
 * @since Mar 15, 2017
 */
public class StringUtilsTest_TestNG {
    @DataProvider
    private static Object[][] getConcatStrings() {
        return new Object[][]{
                {"a", "b", ", ", "a, b"},
                {"b", "c", " - ", "b - c"},
                {"c", "d", " : ", "c : d"},
                {"d", "e", " <=> ", "d <=> e"}
        };
    }

    @DataProvider
    private static Object[][] getSplitStrings() {
        return new Object[][]{
                {"a, b", ", ", new String[] {"a", "b"}},
                {"b - c", " - ", new String[] {"b", "c"}},
                {"c : d", " : ", new String[] {"c", "d"}},
                {"d <=> e", " <=> ", new String[] {"d", "e"}}
        };
    }

    @Test(dataProvider = "getConcatStrings")
    public void testConcat(String s1, String s2, String delimiter, String expected) throws Exception {
        assertEquals(StringUtils.concat(s1, s2, delimiter), expected);
    }

    @Test(dataProvider = "getSplitStrings")
    public void testSplit(String s1, String delimiter, String[] expected) throws Exception {
        assertEquals(StringUtils.split(s1, delimiter), expected);
    }
}