package com.epam.tc.hw4.dataproviders.components;

import org.testng.annotations.DataProvider;

/**
 * HeaderMenuData - Data Provider for 'Header Menu' component.
 *
 * @author Aleksandr Liadov
 */
public class HeaderMenuData {

  /**
   * Method returns test data for 'Header Menu' component.
   *
   * @return Object[][] - data provider
   */
  @DataProvider(name = "header data")
  public static Object[][] getHeaderData() {
    return new Object[][]{
        {"HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS"}
    };
  }
}

