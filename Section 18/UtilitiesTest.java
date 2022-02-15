package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities util;

    @Before
    public void setup(){
        util=new Utilities();
    }

    @Test
    public void everyNthChar() {
        char[] c = {'h','e','l','l','o'};
        assertArrayEquals(new char[]{'e', 'l'}, util.everyNthChar(c,2));
        assertArrayEquals(new char[]{'h','e','l','l','o'}, util.everyNthChar(c,8));

    }

    @Test
    public void removePairs() throws Exception{
        assertEquals("ABCDEF",util.removePairs("AABCDDEFF"));
        assertEquals("ABCDEBF",util.removePairs("ABBCDDEBFF"));
        assertNull("The string was null", util.removePairs(null));
        assertEquals("A",util.removePairs("A"));
        assertEquals("",util.removePairs(""));
    }

    @Test
    public void converter() {
        assertEquals(300,util.converter(10,5));

    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_divideByZero(){
        util.converter(10,0);
    }

    @Test
    public void nullIfOddLength() {
        assertNull("string entered is of odd length",util.nullIfOddLength("12345"));
        assertEquals("123456",util.nullIfOddLength("123456"));

    }
}