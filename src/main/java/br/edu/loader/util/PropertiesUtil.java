package br.edu.loader.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by rodrigopinheiro on 3/22/16.
 */
public enum PropertiesUtil {

    INSTANCE;

    private Properties properties = new Properties();

    private PropertiesUtil() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("loader.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
