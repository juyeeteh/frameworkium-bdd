package net.moodel.demo.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class to read from properties setting system properties before tests begin - Frameworkium requires certain
 * system properties to be set prior to test execution
 */
public class PropertyUtils {

    private static final String PROPERTIES_PATH = "src/test/resources/config.properties";
    private static Properties properties;

    public static void loadProperties() {
        properties = new Properties();
        try(InputStream fileStream = new FileInputStream(PROPERTIES_PATH)) {
            properties.load(fileStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file");
        }
        setSystemProperties();
    }

    public static String readProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setSystemProperties(){
        for (String property : properties.stringPropertyNames()){
            System.setProperty(property,readProperty(property));
        }
    }

}
