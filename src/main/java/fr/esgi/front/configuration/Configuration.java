package fr.esgi.front.configuration;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Properties;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;

@Dependent
public class Configuration {

    private static final String CONFIG_FILE_PATH = "config/config.properties";

    private Properties properties;

    private void loadConfig() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    @Produces
    public String getRentProperiesAPIUrl() throws IOException {
        loadConfig();
        return properties.getProperty("rentProperiesAPI.url");
    }


    public String getRentCarUrl() throws IOException {
        loadConfig();
        return properties.getProperty("rentCar.url");
    }

    @Produces
    public HttpClient getClient(){
        return HttpClient.newHttpClient();
    }
}