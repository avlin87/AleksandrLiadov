package com.epam.tc.hw3.utils;

import com.epam.tc.hw3.data.DataEnum;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesLoaderTest {

  private static final Properties properties = new Properties();

  public static String getProperty(DataEnum dataEnum) {
    if (!properties.containsKey(dataEnum.getValue())) {
      readUserProperties();
    }
    return properties.getProperty(dataEnum.getValue());
  }

  private static void readUserProperties() {
    String fileLocation = "src/test/resources/data/user-data.properties";
    try (FileInputStream inputStream = new FileInputStream(fileLocation)) {
      properties.load(inputStream);
    } catch (IOException e) {
      log.error("Read of User properties File Failed: ", e);
    }
  }

}