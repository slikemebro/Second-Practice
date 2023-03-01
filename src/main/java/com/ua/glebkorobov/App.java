package com.ua.glebkorobov;

import com.ua.glebkorobov.exception.WrongFormat;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Hello world!
 *
 */
public class App {

    private static final String FILE_NAME_PROPERTIES = "myProp.properties";

    private static final Logger logger = LogManager.getLogger(App.class);

    public static final String FORMAT_OF_FIGURES = "format";

    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String INCREMENT = "increment";


    public static void main( String[] args ) throws WrongFormat {
        checkFormat();
    }

    private static void checkFormat() throws WrongFormat {
        if (System.getProperty(FORMAT_OF_FIGURES) == null ||
                System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("int")) {
            logger.info("Format is int");
            makeMultiplicationTableInteger();
        }else if (System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("byte")) {
            logger.info("Format is byte");
            makeMultiplicationTableByte();
        }else if (System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("long")) {
            logger.info("Format is long");
            makeMultiplicationTableLong();
        }else if (System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("double")) {
            logger.info("Format is double");
            makeMultiplicationTableDouble();
        }else if (System.getProperty(FORMAT_OF_FIGURES).equalsIgnoreCase("float")) {
            logger.info("Format is float");
            makeMultiplicationTableFloat();
        }else{
            logger.warn("wrong format");
            throw new WrongFormat("wrong format");
        }
    }

    private static void makeMultiplicationTableInteger() {
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        logger.info("Got min max and increment by format int");
        int min = Integer.parseInt(property.getValueFromProperty(MIN));
        int max = Integer.parseInt(property.getValueFromProperty(MAX));
        int increment = Integer.parseInt(property.getValueFromProperty(INCREMENT));

        StringBuilder result = new StringBuilder();

        for (int i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (int j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append(" | ");
            }
            logger.info(result);
        }
    }

    private static void makeMultiplicationTableByte(){
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        logger.info("Got min max and increment by format byte");
        byte min = Byte.parseByte(property.getValueFromProperty(MIN));
        byte max = Byte.parseByte(property.getValueFromProperty(MAX));
        byte increment = Byte.parseByte(property.getValueFromProperty(INCREMENT));

        StringBuilder result = new StringBuilder();

        for (byte i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (byte j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append(" | ");
            }
            logger.info(result);
        }
    }
    private static void makeMultiplicationTableLong(){
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        logger.info("Got min max and increment by format long");
        long min = Long.parseLong(property.getValueFromProperty(MIN));
        long max = Long.parseLong(property.getValueFromProperty(MAX));
        long increment = Long.parseLong(property.getValueFromProperty(INCREMENT));

        StringBuilder result = new StringBuilder();

        for (long i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (long j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append(" | ");
            }
            logger.info(result);
        }
    }
    private static void makeMultiplicationTableDouble(){
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        logger.info("Got min max and increment by format double");
        double min = Double.parseDouble(property.getValueFromProperty(MIN));
        double max = Double.parseDouble(property.getValueFromProperty(MAX));
        double increment = Double.parseDouble(property.getValueFromProperty(INCREMENT));

        StringBuilder result = new StringBuilder();

        for (double i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (double j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append(" | ");
            }
            logger.info(result);
        }
    }
    private static void makeMultiplicationTableFloat(){
        GetProperty property = new GetProperty(FILE_NAME_PROPERTIES);

        logger.info("Got min max and increment by format float");
        float min = Float.parseFloat(property.getValueFromProperty(MIN));
        float max = Float.parseFloat(property.getValueFromProperty(MAX));
        float increment = Float.parseFloat(property.getValueFromProperty(INCREMENT));

        StringBuilder result = new StringBuilder();

        for (float i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (float j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append(" | ");
            }
            logger.info(result);
        }
    }

}
