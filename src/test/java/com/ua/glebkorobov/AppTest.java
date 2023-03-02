package com.ua.glebkorobov;

import com.ua.glebkorobov.exception.WrongFormat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void makeStandardProp(){
        App.fileNameProperties = "test.properties";
    }

    @Test
    public void integerFormatCheck() throws WrongFormat {
        assertEquals("integer", App.checkFormat("INT"));
        assertEquals("integer", App.checkFormat("int"));
        assertEquals("integer", App.checkFormat("iNt"));
        assertEquals("integer", App.checkFormat("InT"));
        assertEquals("integer", App.checkFormat("integer"));
        assertEquals("integer", App.checkFormat(null));
        exception.expect(WrongFormat.class);
        App.checkFormat("wrong");
    }

    @Test
    public void byteFormatCheck() throws WrongFormat {
        assertEquals("byte", App.checkFormat("BYTE"));
        assertEquals("byte", App.checkFormat("byte"));
        assertEquals("byte", App.checkFormat("ByTe"));
        assertEquals("byte", App.checkFormat("bYtE"));
        exception.expect(WrongFormat.class);
        App.checkFormat("wrong");
    }

    @Test
    public void longFormatCheck() throws WrongFormat {
        assertEquals("long", App.checkFormat("LONG"));
        assertEquals("long", App.checkFormat("long"));
        assertEquals("long", App.checkFormat("LoNg"));
        assertEquals("long", App.checkFormat("lOnG"));
        exception.expect(WrongFormat.class);
        App.checkFormat("wrong");
    }

    @Test
    public void doubleFormatCheck() throws WrongFormat {
        assertEquals("double", App.checkFormat("DOUBLE"));
        assertEquals("double", App.checkFormat("double"));
        assertEquals("double", App.checkFormat("DoUbLe"));
        assertEquals("double", App.checkFormat("dOuBlE"));
        exception.expect(WrongFormat.class);
        App.checkFormat("wrong");
    }

    @Test
    public void floatFormatCheck() throws WrongFormat {
        assertEquals("float", App.checkFormat("FLOAT"));
        assertEquals("float", App.checkFormat("float"));
        assertEquals("float", App.checkFormat("FlOaT"));
        assertEquals("float", App.checkFormat("fLOaT"));
        exception.expect(WrongFormat.class);
        App.checkFormat("wrong");
    }

    @Test
    public void integerMultiplicationTable() {
        int min = 1, max = 10, increment = 2;
        int sumOfTable = 0;

        for (int i = min; i <= max; i += increment) {
            for (int j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, App.makeMultiplicationTableInteger(min, max, increment));
    }

    @Test
    public void byteMultiplicationTable() {
        byte min = 1, max = 10, increment = 2;
        byte sumOfTable = 0;

        for (byte i = min; i <= max; i += increment) {
            for (byte j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, App.makeMultiplicationTableByte(min, max, increment));
    }

    @Test
    public void longMultiplicationTable() {
        long min = 1, max = 10, increment = 2;
        long sumOfTable = 0;

        for (long i = min; i <= max; i += increment) {
            for (long j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, App.makeMultiplicationTableLong(min, max, increment));
    }

    @Test
    public void doubleMultiplicationTable() {
        double min = 1, max = 10, increment = 2;
        double sumOfTable = 0;

        for (double i = min; i <= max; i += increment) {
            for (double j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, App.makeMultiplicationTableDouble(min, max, increment),
                0);
    }

    @Test
    public void floatMultiplicationTable() {
        float min = 1, max = 10, increment = 2;
        float sumOfTable = 0;

        for (float i = min; i <= max; i += increment) {
            for (float j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, App.makeMultiplicationTableFloat(min, max, increment),
                0);
    }

    @Test
    public void checkForExceptionWrongFormatForFigures() throws WrongFormat {
        exception.expect(WrongFormat.class);
        App.fileNameProperties = "testForApp.properties";
        App.checkFormat("inta");
    }

    @Test
    public void checkForExceptionWrongFormat() throws WrongFormat {
        exception.expect(WrongFormat.class);
        App.fileNameProperties = "testForApp.properties";
        App.checkFormat(null);
    }
}
