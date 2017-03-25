package com.example.helper;

/**
 * @author David.Shahbazyan
 * @since Mar 15, 2017
 */
public class StringUtils {
    public static String concat(String s1, String s2, String delimiter) {
        return s1 + delimiter + s2;
    }

    public static String[] split(String s1, String delimiter) {
        return s1.split(delimiter);
    }
}
