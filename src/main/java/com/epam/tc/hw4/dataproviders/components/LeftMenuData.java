package com.epam.tc.hw4.dataproviders.components;

import org.testng.annotations.DataProvider;

/**
 * LeftMenuData - Data Provider for 'Left Menu' component.
 *
 * @author Aleksandr Liadov
 */
public class LeftMenuData {

  /**
   * Method returns expected text elements for 'Left Menu' component.
   *
   * @return Object[][] - data provider
   */
  @DataProvider(name = "left menu data")
  public static Object[][] getLeftMenuData() {
    return new Object[][]{
        {"Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs"}
    };
  }
}