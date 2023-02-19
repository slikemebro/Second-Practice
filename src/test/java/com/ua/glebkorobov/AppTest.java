package com.ua.glebkorobov;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
        assertTrue( true );
        assertTrue( true );
        assertTrue( true );
    }

    @Test
    public void whenEmptyString_thenAccept() {
        App palindromeTester = new App();
        assertTrue(palindromeTester.isPalindrome(""));
        assertTrue(palindromeTester.isPalindrome("noon"));
        assertFalse(palindromeTester.isPalindrome("noan"));
    }
}
