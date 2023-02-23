package com.ua.glebkorobov;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GetPropertyTest {

    private GetProperty getProperty;

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Before
    public void before() {
        getProperty = new GetProperty("test.properties");
    }

    @Test
    public void getValueFromProperty() {
        assertEquals("1", getProperty.getValueFromProperty("min"));
        assertEquals("1", getProperty.getValueFromProperty("mIn"));
        assertEquals("6", getProperty.getValueFromProperty("max"));
        assertEquals("6", getProperty.getValueFromProperty("MAX"));
        assertEquals("2", getProperty.getValueFromProperty("increment"));
        assertEquals("2", getProperty.getValueFromProperty("InCrEmEnT"));
    }

    @Test
    public void getValueFromPropertyWithWrongKey() {
        assertNull(getProperty.getValueFromProperty("test"));
    }

    @Test
    public void getFileNameProperty() {
        assertEquals("test.properties", getProperty.getFileNameProperty());
    }

    @Test
    public void createGetPropertyWithWrongNameOfFile() {
        exception.expect(RuntimeException.class);
        getProperty = new GetProperty("wrongName.properties");
    }

    @Test
    public void setFileNameProperty() {
        getProperty.setFileNameProperty("test1.properties");
        assertEquals("test1.properties", getProperty.getFileNameProperty());
        assertEquals("10", getProperty.getValueFromProperty("min"));
        assertEquals("62", getProperty.getValueFromProperty("max"));
        assertEquals("23", getProperty.getValueFromProperty("increment"));

    }
}