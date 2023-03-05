package com.ua.glebkorobov;

import com.ua.glebkorobov.exception.WrongFormat;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class App {

    public static final String FILE_NAME_PROPERTIES = "myProp.properties";

    private static final Logger logger = LogManager.getLogger(App.class);

    public static final String FORMAT_OF_FIGURES = "format";


    public static void main(String[] args) throws WrongFormat {
        String format = System.getProperty(FORMAT_OF_FIGURES);
        logger.info("got system property");
        MultiplicationTable multiplicationTable = new MultiplicationTable(format);
        logger.info("created MultiplicationTable class");
        multiplicationTable.checkFormat(FILE_NAME_PROPERTIES);
    }
}