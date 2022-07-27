package com.epam.tc.hw1.data;

import org.testng.annotations.DataProvider;

public class SumDataProvider {

  @DataProvider
  public static Object[][] sumLongTestData() {
    return new Object[][]{
        {10, -11, -1L},
        {-12L, -13L, -25L},
        {912L, 9999999999999L, 10000000000911L},
        {0L, 0L, 0L}
    };
  }

  @DataProvider
  public static Object[][] sumDoubleTestData() {
    return new Object[][]{
        {3.3, 1.317, 4.617},
        {-12.2, -13.3, -25.5},
        {0.0, 0.0, 0.0}
    };
  }
}
