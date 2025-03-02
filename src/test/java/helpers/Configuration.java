package helpers;
import java.io.IOException;
import java.util.Properties;


public class Configuration {
    private static final String SITE_ADDRESS_PROPERTY = "test.site.url";

    private static final String DRIVER_LOCATION_PROPERTY = "driver.location";
    private static final String DRIVER_BROWSER = "driver.browser";
    private static Configuration configuration;
    private Properties properties;
    private String siteURL;
    private String driverLocation;
    private String driverBrowser;


    private Configuration() {
        properties = new Properties();
        try {
            properties.load(Configuration.class.getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException exception) {
            throw new ExceptionInInitializerError(exception);
        }
        siteURL = extractProperty(SITE_ADDRESS_PROPERTY);
        driverLocation = extractProperty(DRIVER_LOCATION_PROPERTY);
        driverBrowser = extractProperty(DRIVER_BROWSER);

    }
    private String extractProperty(String propertyName) {
        String property = System.getProperty(propertyName);
        if(property== null){
            property = properties.getProperty(propertyName);
        }
        return property;
    }

    public static Configuration getConfiguration(){
        if (configuration == null){
            configuration = new Configuration();
        }
        return configuration;
    }

    public String getSiteURL(){
        return siteURL;
    }
    public String getDriverLocation(){
        return driverLocation;
    }

    public String getDriverBrowser(){
        return driverBrowser;
    }
}
