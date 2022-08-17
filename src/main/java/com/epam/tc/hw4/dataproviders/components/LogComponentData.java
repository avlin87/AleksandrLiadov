package com.epam.tc.hw4.dataproviders.components;

import org.testng.annotations.DataProvider;

/**
 * LogComponentData - Data Provider for 'Log Component'.
 *
 * @author Aleksandr Liadov
 */
public class LogComponentData {

  /**
   * Method returns expected patterns for 'Log Component'.
   *
   * @return Object[][] - data provider
   */
  @DataProvider(name = "log component data")
  public static Object[][] getLogComponentData() {
    return new Object[][]{
        {"^(\\d{2}.?){3}(?i)(Water: condition changed to true)$",
            "^(\\d{2}.?){3}(?i)(Wind: condition changed to true)$",
            "^(\\d{2}.?){3}(?i)(metal: value changed to Selen)$",
            "^(\\d{2}.?){3}(?i)(Colors: value changed to Yellow)$"}
    };
  }

}
