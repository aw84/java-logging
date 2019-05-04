package pl.aw84.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class ApplicationProperties {
    static final Logger logger = LoggerFactory.getLogger(ApplicationProperties.class.getCanonicalName());

    private Properties get() {
        Properties properties = new Properties();
        try {
            InputStream input = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(input);
            return properties;
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return properties;
    }

    String get(String propertyName) {
        return System.getProperty(propertyName, get().getProperty(propertyName));
    }
}
