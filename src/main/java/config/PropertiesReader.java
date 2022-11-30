package config;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {
    private static FileReader reader;
    private static Properties properties;

    static {
        try{
            reader = new FileReader("src/main/resources/testdata.properties");
            properties = new Properties();
            properties.load(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {return properties.getProperty(key);}
}
