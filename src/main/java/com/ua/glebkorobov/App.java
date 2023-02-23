package com.ua.glebkorobov;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Hello world!
 *
 */
public class App {

    private static final String FILE_NAME_PROPERTIES = "myP.properties";

    private static final Logger logger = LogManager.getLogger(App.class);

    public static final String FORMAT_OF_FIGURES = "format";


    public static void main( String[] args ) {
        checkFormat();
    }

    private static void checkFormat() {

        if (System.getProperty(FORMAT_OF_FIGURES) == null ||
                System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("int")) {
            makeMultiplicationTableInteger();
        }else if (System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("byte")) {
            makeMultiplicationTableByte();
        }else if (System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("long")) {
            makeMultiplicationTableLong();
        }else if (System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("double")) {
            makeMultiplicationTableDouble();
        }else if (System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("float")) {
            makeMultiplicationTableFloat();
        }
    }

    private static void makeMultiplicationTableInteger() {
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        int min = Integer.valueOf(property.getValueFromProperty("min"));
        int max = Integer.valueOf(property.getValueFromProperty("max"));
        int increment = Integer.valueOf(property.getValueFromProperty("increment"));

        String result = "";

        for (int i = min; i <= max; i += increment) {
            result = "";
            for (int j = min; j <= max; j += increment) {
                result += (j + " * " + i + " = " + (i * j) + " | ");
            }
            logger.info(result);
        }
    }

    private static void makeMultiplicationTableByte(){
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        byte min = Byte.valueOf(property.getValueFromProperty("min"));
        byte max = Byte.valueOf(property.getValueFromProperty("max"));
        byte increment = Byte.valueOf(property.getValueFromProperty("increment"));

        String result = "";

        for (byte i = min; i <= max; i += increment) {
            result = "";
            for (byte j = min; j <= max; j += increment) {
                result += (j + " * " + i + " = " + (i * j) + " | ");
            }
            logger.info(result);
        }
    }
    private static void makeMultiplicationTableLong(){
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        long min = Long.valueOf(property.getValueFromProperty("min"));
        long max = Long.valueOf(property.getValueFromProperty("max"));
        long increment = Long.valueOf(property.getValueFromProperty("increment"));

        String result = "";

        for (long i = min; i <= max; i += increment) {
            result = "";
            for (long j = min; j <= max; j += increment) {
                result += (j + " * " + i + " = " + (i * j) + " | ");
            }
            logger.info(result);
        }
    }
    private static void makeMultiplicationTableDouble(){
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        double min = Double.valueOf(property.getValueFromProperty("min"));
        double max = Double.valueOf(property.getValueFromProperty("max"));
        double increment = Double.valueOf(property.getValueFromProperty("increment"));

        String result = "";

        for (double i = min; i <= max; i += increment) {
            result = "";
            for (double j = min; j <= max; j += increment) {
                result += (j + " * " + i + " = " + (i * j) + " | ");
            }
            logger.info(result);
        }
    }
    private static void makeMultiplicationTableFloat(){
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        float min = Float.valueOf(property.getValueFromProperty("min"));
        float max = Float.valueOf(property.getValueFromProperty("max"));
        float increment = Float.valueOf(property.getValueFromProperty("increment"));

        String result = "";

        for (float i = min; i <= max; i += increment) {
            result = "";
            for (float j = min; j <= max; j += increment) {
                result += (j + " * " + i + " = " + (float) (i * j) + " | ");
            }
            logger.info(result);
        }
    }

}
