package com.epam.tc.hw4.utils;

import com.epam.tc.hw4.dataproviders.DataEnum;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

/**
 * PropertiesLoaderTest - util class for loading user data from properties file.
 *
 * @author Aleksandr Liadov
 */
@Slf4j
public class PropertiesLoaderTest {

  private static final Properties properties = new Properties();

  /**
   * Method returns requested value from Properties. Read value from file in case value is missing.
   *
   * @param dataEnum - type of data to be loaded
   * @return String
   */
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