package com.ua.glebkorobov;

import com.ua.glebkorobov.exception.WrongFormat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
class MultiplicationTableTest {


    @Mock
    MultiplicationTable multiplicationTable;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void checkFormatThrowException() throws WrongFormat {
        when(multiplicationTable.checkFormat(any())).thenThrow(WrongFormat.class);
        assertThrows(WrongFormat.class, () -> multiplicationTable.checkFormat(any()));
    }

    @Test
    void integerFormatCheck() throws WrongFormat {
        when(multiplicationTable.checkFormat(
                Mockito.argThat(arg -> arg == null || arg.equals("int") || arg.equals("INT") ||
                        arg.equals("integer") || arg.equals("INTEGER"))))
                .thenReturn("integer");
        assertEquals("integer", multiplicationTable.checkFormat("INT"));
        assertEquals("integer", multiplicationTable.checkFormat("int"));
        assertEquals("integer", multiplicationTable.checkFormat("integer"));
        assertEquals("integer", multiplicationTable.checkFormat("INTEGER"));
    }

    @Test
    void byteFormatCheck() throws WrongFormat {
        when(multiplicationTable.checkFormat(
            Mockito.argThat(arg -> arg == null || arg.equals("byte") || arg.equals("BYTE"))))
            .thenReturn("byte");
        assertEquals("byte", multiplicationTable.checkFormat("byte"));
        assertEquals("byte", multiplicationTable.checkFormat("BYTE"));
    }

    @Test
    void longFormatCheck() throws WrongFormat {
        when(multiplicationTable.checkFormat(
                Mockito.argThat(arg -> arg == null || arg.equals("long") || arg.equals("LONG"))))
                .thenReturn("long");
        assertEquals("long", multiplicationTable.checkFormat("long"));
        assertEquals("long", multiplicationTable.checkFormat("LONG"));
    }

    @Test
    void doubleFormatCheck() throws WrongFormat {
        when(multiplicationTable.checkFormat(
                Mockito.argThat(arg -> arg == null || arg.equals("double") || arg.equals("DOUBLE"))))
                .thenReturn("double");
        assertEquals("double", multiplicationTable.checkFormat("double"));
        assertEquals("double", multiplicationTable.checkFormat("DOUBLE"));
    }

    @Test
    void floatFormatCheck() throws WrongFormat {
        when(multiplicationTable.checkFormat(
                Mockito.argThat(arg -> arg == null || arg.equals("float") || arg.equals("FLOAT"))))
                .thenReturn("float");
        assertEquals("float", multiplicationTable.checkFormat("float"));
        assertEquals("float", multiplicationTable.checkFormat("FLOAT"));
    }

    @Test
    void integerMultiplicationTable() {
        MultiplicationTable table = new MultiplicationTable("int");
        int min = 1, max = 10, increment = 2;
        int sumOfTable = 0;

        for (int i = min; i <= max; i += increment) {
            for (int j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, table.makeMultiplicationTableInteger(min, max, increment));
    }

    @Test
    void byteMultiplicationTable() {
        MultiplicationTable table = new MultiplicationTable("int");

        byte min = 1, max = 10, increment = 2;
        byte sumOfTable = 0;

        for (byte i = min; i <= max; i += increment) {
            for (byte j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, table.makeMultiplicationTableByte(min, max, increment));
    }

    @Test
    void longMultiplicationTable() {
        MultiplicationTable table = new MultiplicationTable("int");

        long min = 1, max = 10, increment = 2;
        long sumOfTable = 0;

        for (long i = min; i <= max; i += increment) {
            for (long j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, table.makeMultiplicationTableLong(min, max, increment));
    }

    @Test
    void doubleMultiplicationTable() {
        MultiplicationTable table = new MultiplicationTable("int");

        double min = 1, max = 10, increment = 2;
        double sumOfTable = 0;

        for (double i = min; i <= max; i += increment) {
            for (double j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, table.makeMultiplicationTableDouble(min, max, increment),0);
    }

    @Test
    void floatMultiplicationTable() {
        MultiplicationTable table = new MultiplicationTable("int");

        float min = 1, max = 10, increment = 2;
        float sumOfTable = 0;

        for (float i = min; i <= max; i += increment) {
            for (float j = min; j <= max; j += increment) {
                sumOfTable += i * j;
            }
        }
        assertEquals(sumOfTable, table.makeMultiplicationTableFloat(min, max, increment),0);
    }

    @Test
    void checkForExceptionWrongFormat() {
        MultiplicationTable table = new MultiplicationTable("int");
        assertThrows(WrongFormat.class, () -> table.checkFormat("testForApp.properties"));
    }
}
