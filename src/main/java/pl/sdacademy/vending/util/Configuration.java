package pl.sdacademy.vending.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private final Properties properties;
    private final String nameFile = "application.properties";

    public Configuration() {
        properties = new Properties();

        try (InputStream propertiesStream = ClassLoader.getSystemResourceAsStream(nameFile)) {
            properties.load(propertiesStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        properties.list(System.out);
    }

    public Long getLongProperty(String paramName, Long defaultValue){
        String propertyValue = properties.getProperty(paramName);
        if(propertyValue == null) {
            return defaultValue;
        }
        return Long.parseLong(properties.getProperty(paramName));
    }

    public String getStringPropoerty(String paramName, String defaultValue){
        return properties.getProperty(paramName, defaultValue);
    }
}
