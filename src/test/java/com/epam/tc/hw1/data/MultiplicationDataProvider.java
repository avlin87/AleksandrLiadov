package com.epam.tc.hw1.data;

import org.testng.annotations.DataProvider;

public class MultiplicationDataProvider {

  @DataProvider
  public static Object[][] multLongTestData() {
    return new Object[][]{
        {12L, 90L, 1080L},
        {-12L, 0L, 0L},
        {0L, 999L, 0L}
    };
  }

  @DataProvider
  public static Object[][] multDoubleTestData() {
    return new Object[][]{
        {10.2, -90.9, -927.18},
        {-90.9, -10.1, 918.09},
        {0.0, -999.0, 0.0}
    };
  }

}
