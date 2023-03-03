package com.ua.glebkorobov;

import com.ua.glebkorobov.exception.WrongFormat;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



/**
 * Hello world!
 */
public class App {

    public static String fileNameProperties = "myProp.properties";

    private static final Logger logger = LogManager.getLogger(App.class);

    public static final String FORMAT_OF_FIGURES = "format";

    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String INCREMENT = "increment";


    public static void main(String[] args) throws WrongFormat {
        String format = System.getProperty(FORMAT_OF_FIGURES);
        checkFormat(format);
    }

    public static String checkFormat(String format) throws WrongFormat {
        GetProperty property = new GetProperty(fileNameProperties);

        String formatOfException = null;

        try {
            if ((format == null) ||
                    format.equalsIgnoreCase("int") ||
                    format.equalsIgnoreCase("integer")) {
                logger.info("Format is int");

                int min;
                int max;
                int increment;
                formatOfException = "integer";

                min = Integer.parseInt(property.getValueFromProperty(MIN));
                max = Integer.parseInt(property.getValueFromProperty(MAX));
                increment = Integer.parseInt(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format int");

                makeMultiplicationTableInteger(min, max, increment);

                return "integer";
            } else if (format.equalsIgnoreCase("byte")) {
                logger.info("Format is byte");

                byte min;
                byte max;
                byte increment;

                formatOfException = "byte";

                min = Byte.parseByte(property.getValueFromProperty(MIN));
                max = Byte.parseByte(property.getValueFromProperty(MAX));
                increment = Byte.parseByte(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format byte");

                makeMultiplicationTableByte(min, max, increment);

                return "byte";
            } else if (format.equalsIgnoreCase("long")) {
                logger.info("Format is long");

                long min;
                long max;
                long increment;

                formatOfException = "long";

                min = Long.parseLong(property.getValueFromProperty(MIN));
                max = Long.parseLong(property.getValueFromProperty(MAX));
                increment = Long.parseLong(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format long");

                makeMultiplicationTableLong(min, max, increment);

                return "long";
            } else if (format.equalsIgnoreCase("double")) {
                logger.info("Format is double");

                double min;
                double max;
                double increment;

                formatOfException = "double";

                min = Double.parseDouble(property.getValueFromProperty(MIN));
                max = Double.parseDouble(property.getValueFromProperty(MAX));
                increment = Double.parseDouble(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format double");

                makeMultiplicationTableDouble(min, max, increment);

                return "double";
            } else if (format.equalsIgnoreCase("float")) {
                logger.info("Format is float");

                float min;
                float max;
                float increment;

                formatOfException = "float";

                min = Float.parseFloat(property.getValueFromProperty(MIN));
                max = Float.parseFloat(property.getValueFromProperty(MAX));
                increment = Float.parseFloat(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format float");

                makeMultiplicationTableFloat(min, max, increment);

                return "float";
            } else {
                logger.warn("wrong format");
                throw new WrongFormat("wrong format");
            }
        } catch (NumberFormatException e) {
            logger.error("Used wrong format of figures");
            throw new WrongFormat("Wrong format of figures should be: " + formatOfException);
        }
    }

    public static int makeMultiplicationTableInteger(int min, int max, int increment) {
        StringBuilder result = new StringBuilder();

        int sumOfTable = 0;

        for (int i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (int j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append("  ");
                sumOfTable += i * j;
            }
            logger.info(result);
        }
        return sumOfTable;
    }

    public static byte makeMultiplicationTableByte(byte min, byte max, byte increment) {
        StringBuilder result = new StringBuilder();

        byte sumOfTable = 0;

        for (byte i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (byte j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append("  ");
                sumOfTable += i * j;
            }
            logger.info(result);
        }
        return sumOfTable;
    }

    public static long makeMultiplicationTableLong(long min, long max, long increment) {
        StringBuilder result = new StringBuilder();

        long sumOfTable = 0;

        for (long i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (long j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append("  ");
                sumOfTable += i * j;
            }
            logger.info(result);
        }
        return sumOfTable;
    }

    public static double makeMultiplicationTableDouble(double min, double max, double increment) {
        StringBuilder result = new StringBuilder();

        double sumOfTable = 0;

        for (double i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (double j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append("  ");
                sumOfTable += i * j;
            }
            logger.info(result);
        }
        return sumOfTable;
    }

    public static float makeMultiplicationTableFloat(float min, float max, float increment) {
        StringBuilder result = new StringBuilder();

        float sumOfTable = 0;

        for (float i = min; i <= max; i += increment) {
            result.delete(0, result.length());
            for (float j = min; j <= max; j += increment) {
                result.append(j).append(" * ").append(i).append(" = ").append(i * j).append("  ");
                sumOfTable += i * j;
            }
            logger.info(result);
        }
        return sumOfTable;
    }
}