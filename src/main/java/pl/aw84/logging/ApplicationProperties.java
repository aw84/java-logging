package pl.aw84.logging;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    public Properties get() throws IOException {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(input);
        return properties;
    }
}
