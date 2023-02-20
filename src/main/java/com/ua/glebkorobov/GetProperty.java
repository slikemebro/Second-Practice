package com.ua.glebkorobov;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperty {

    private String fileNameProperty;
    private static final Logger logger = LogManager.getLogger(GetProperty.class);
    private Properties properties = new Properties();

    public GetProperty(String fileNameProperty) {
        this.fileNameProperty = fileNameProperty;
        loadFile(this.fileNameProperty);
    }

    private void loadFile(String nameFile) {
        try {
            InputStream is = GetProperty.class.getResourceAsStream(fileNameProperty);
            properties.load(is);
            logger.info("Getting properties");
        } catch (Exception e) {
            logger.warn("Properties hasn't found");
//            throw new RuntimeException(e);
        }
    }

    public String getValueFromProperty(String key) {
        return properties.getProperty(key);
    }

    public String getFileNameProperty() {
        return fileNameProperty;
    }

    public void setFileNameProperty(String fileNameProperty) {
        this.fileNameProperty = fileNameProperty;
        loadFile(this.fileNameProperty);
    }
}
