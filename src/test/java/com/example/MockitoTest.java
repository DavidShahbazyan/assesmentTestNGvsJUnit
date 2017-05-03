package com.example;

import com.example.enums.SecurityStatus;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * @author David.Shahbazyan
 * @since May 03, 2017
 */
public class MockitoTest {
    // demonstrates the return of multiple values
    @Test
    public void testMoreThanOneReturnValue() {
        Iterator<String> i = mock(Iterator.class);
        when(i.next()).thenReturn("Val1").thenReturn("val2");
        String result = i.next() + " " + i.next();
        //assert
        assertEquals("Val1 val2", result);
    }

    // this test demonstrates how to return values based on the input
    @Test
    public void testReturnValueDependentOnMethodParameter() {
        Comparable<String> c = mock(Comparable.class);
        when(c.compareTo("Val1")).thenReturn(1);
        when(c.compareTo("Val2")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Val1"));
    }

    // this test demonstrates how to return values independent of the input value
    @Test
    public void testReturnValueInDependentOnMethodParameter() {
        Comparable<Integer> c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //assert
        assertEquals(-1, c.compareTo(9));
    }

    // return a value based on the type of the provide parameter
    @Test
    public void testReturnValueInDependentOnMethodParameter2() {
        Comparable<SecurityStatus> c = mock(Comparable.class);
        when(c.compareTo(isA(SecurityStatus.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(SecurityStatus.OK));
    }

    // using when(...).thenReturn(...) method chain to throw an exception
    @Test
    public void testThrowExceptionWhenKeyNotExists() {
        Properties properties = mock(Properties.class);
        when(properties.get("foo")).thenReturn("bar");
        when(properties.get("blah")).thenThrow(new IllegalArgumentException("No key found!"));
        try {
            assertEquals("bar", properties.get("foo"));
            properties.get("blah");
            fail("\"blah\" key does not exist!");
        } catch (IllegalArgumentException ex) {
            // success!
        }
    }
}
