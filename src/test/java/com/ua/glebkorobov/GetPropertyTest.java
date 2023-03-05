package com.ua.glebkorobov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class GetPropertyTest {

    private GetProperty getProperty;

    @BeforeEach
    void before() {
        getProperty = new GetProperty("test.properties");
    }

    @Test
    void getValueFromProperty() {
        assertEquals("1", getProperty.getValueFromProperty("min"));
        assertEquals("1", getProperty.getValueFromProperty("mIn"));
        assertEquals("6", getProperty.getValueFromProperty("max"));
        assertEquals("6", getProperty.getValueFromProperty("MAX"));
        assertEquals("2", getProperty.getValueFromProperty("increment"));
        assertEquals("2", getProperty.getValueFromProperty("InCrEmEnT"));
    }

    @Test
    void getValueFromPropertyWithWrongKey() {
        assertNull(getProperty.getValueFromProperty("test"));
    }

    @Test
    void getFileNameProperty() {
        assertEquals("test.properties", getProperty.getFileNameProperty());
    }

    @Test
    void createGetPropertyWithWrongNameOfFile() {
        assertThrows(RuntimeException.class,
                () -> getProperty = new GetProperty("wrongName.properties"));
    }

    @Test
    void setFileNameProperty() {
        getProperty.setFileNameProperty("test1.properties");
        assertEquals("test1.properties", getProperty.getFileNameProperty());
        assertEquals("10", getProperty.getValueFromProperty("min"));
        assertEquals("62", getProperty.getValueFromProperty("max"));
        assertEquals("23", getProperty.getValueFromProperty("increment"));

    }
}