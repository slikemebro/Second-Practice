package com.ua.glebkorobov;

import com.ua.glebkorobov.exception.WrongFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class MultiplicationTable {

    String formatOfTable;

    private static final Logger logger = LogManager.getLogger(MultiplicationTable.class);

    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String INCREMENT = "increment";

    public MultiplicationTable(String formatOfTable) {
        this.formatOfTable = formatOfTable;
    }

    public String checkFormat(String fileNameProperties) throws WrongFormat {
        GetProperty property = new GetProperty(fileNameProperties);

        String formatOfFigures = null;
        if (formatOfTable != null) {
            formatOfTable = formatOfTable.trim().toLowerCase(Locale.ROOT);
        }
        try {
            if ((formatOfTable == null) ||
                    formatOfTable.equals("int") ||
                    formatOfTable.equals("integer")) {
                logger.info("Format is int");

                int min;
                int max;
                int increment;
                formatOfFigures = "integer";

                min = Integer.parseInt(property.getValueFromProperty(MIN));
                max = Integer.parseInt(property.getValueFromProperty(MAX));
                increment = Integer.parseInt(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format int");

                makeMultiplicationTableInteger(min, max, increment);

                return formatOfFigures;
            } else if (formatOfTable.equals("byte")) {
                logger.info("Format is byte");

                byte min;
                byte max;
                byte increment;

                formatOfFigures = "byte";

                min = Byte.parseByte(property.getValueFromProperty(MIN));
                max = Byte.parseByte(property.getValueFromProperty(MAX));
                increment = Byte.parseByte(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format byte");

                makeMultiplicationTableByte(min, max, increment);

                return formatOfFigures;
            } else if (formatOfTable.equals("long")) {
                logger.info("Format is long");

                long min;
                long max;
                long increment;

                formatOfFigures = "long";

                min = Long.parseLong(property.getValueFromProperty(MIN));
                max = Long.parseLong(property.getValueFromProperty(MAX));
                increment = Long.parseLong(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format long");

                makeMultiplicationTableLong(min, max, increment);

                return formatOfFigures;
            } else if (formatOfTable.equals("double")) {
                logger.info("Format is double");

                double min;
                double max;
                double increment;

                formatOfFigures = "double";

                min = Double.parseDouble(property.getValueFromProperty(MIN));
                max = Double.parseDouble(property.getValueFromProperty(MAX));
                increment = Double.parseDouble(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format double");

                makeMultiplicationTableDouble(min, max, increment);

                return formatOfFigures;
            } else if (formatOfTable.equals("float")) {
                logger.info("Format is float");

                float min;
                float max;
                float increment;

                formatOfFigures = "float";

                min = Float.parseFloat(property.getValueFromProperty(MIN));
                max = Float.parseFloat(property.getValueFromProperty(MAX));
                increment = Float.parseFloat(property.getValueFromProperty(INCREMENT));

                logger.info("Got min max and increment by format float");

                makeMultiplicationTableFloat(min, max, increment);

                return formatOfFigures;
            } else {
                logger.warn("wrong format");
                throw new WrongFormat("wrong format");
            }
        } catch (NumberFormatException e) {
            logger.error("Used wrong format of figures");
            throw new WrongFormat("Wrong format of figures should be: " + formatOfFigures);
        }
    }

    public int makeMultiplicationTableInteger(int min, int max, int increment) {
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

    public byte makeMultiplicationTableByte(byte min, byte max, byte increment) {
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

    public long makeMultiplicationTableLong(long min, long max, long increment) {
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

    public double makeMultiplicationTableDouble(double min, double max, double increment) {
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

    public float makeMultiplicationTableFloat(float min, float max, float increment) {
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
