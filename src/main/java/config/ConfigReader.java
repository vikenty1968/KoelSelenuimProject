package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
  public   ConfigReader()  {
     this.properties = new Properties();
      InputStream inputStream =
              getClass()
                      .getClassLoader()
                      .getResourceAsStream("config.properties");
       if(inputStream==null){
           throw new RuntimeException("Config file is not found");
       }
      try {
         this.properties.load(inputStream);
      } catch (IOException e) {
          throw new RuntimeException("Failed to read property file",e);
      }

  }
   public String getProperty(String key){
      return properties.getProperty(key);
   }
}
