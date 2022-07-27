package com.epam.tc.hw1.data;

import org.testng.annotations.DataProvider;

public class SubtractionDataProvider {

  @DataProvider
  public static Object[][] subtractionLongTestData() {
    return new Object[][]{
        {91L, 90L, 1L},
        {-12L, -13L, 1L},
        {0L, 0L, 0L}
    };
  }

  @DataProvider
  public static Object[][] subtractionDoubleTestData() {
    return new Object[][]{
        {90.11, 500, -409.89},
        {-12.5, -0.49, -12.01},
        {0.0, 0.0, 0.0}
    };
  }
}
