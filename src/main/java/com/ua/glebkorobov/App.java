package com.ua.glebkorobov;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {

    private static final String FILE_NAME_PROPERTIES = "/myProp.properties";

    private static final Logger logger = LogManager.getLogger(App.class);

    public static final String FORMAT_OF_FIGURES = "format";
    public static final String MIN_OF_FIGURES = "min";
    public static final String MAX_OF_FIGURES = "max";

    public static void main( String[] args ) {
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        checkFormat();
    }

    private static void checkFormat() {
        if (System.getProperty(FORMAT_OF_FIGURES) == null || System.getProperty(FORMAT_OF_FIGURES).equals("int")) {
            int min = 0;
            int max = 0;
            int increment = 0;
            makeMultiplicationTable(min, max, increment);
        }
    }

    private static <E> void makeMultiplicationTable(E min, E max, E increment) {

    }

}
