package pl.aw84.logging;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class App {
    static final Logger logger = LoggerFactory.getLogger(App.class.getCanonicalName());

    public static void main(String[] args) throws IOException {
        ApplicationProperties properties = new ApplicationProperties();

        String coreSite = properties.get("coreSite");
        String hdfsSite = properties.get("hdfsSite");

        logger.debug(coreSite);

        Configuration conf = new Configuration();
        conf.addResource(new Path(coreSite));
        conf.addResource(new Path(hdfsSite));

        FileSystem fileSystem = FileSystem.get(conf);

        logger.debug("file " + args[0] + " exists: " + fileSystem.exists(new Path(args[0])));
    }
}
