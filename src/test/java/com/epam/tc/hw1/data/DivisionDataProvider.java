package com.epam.tc.hw1.data;

import org.testng.annotations.DataProvider;

public class DivisionDataProvider {

  @DataProvider
  public static Object[][] divisionByZeroLongTestData() {
    return new Object[][]{
        {1L, 0L},
        {-12L, 0L},
        {0L, 0L}
    };
  }

  @DataProvider
  public static Object[][] divisionByZeroDoubleTestData() {
    return new Object[][]{
        {1.1, 0.0, Double.POSITIVE_INFINITY},
        {-12.0, 0.0, Double.NEGATIVE_INFINITY}
    };
  }

  @DataProvider
  public static Object[][] divisionLongTestData() {
    return new Object[][]{
        {11L, 2L, 5L},
        {9999999999L, -3L, -3333333333L},
        {0, -3L, 0}
    };
  }

  @DataProvider
  public static Object[][] divisionDoubleTestData() {
    return new Object[][]{
        {11.1, 3.1, 3.58},
        {-30.1, 9.1, -3.31},
        {0, -3.2, 0}
    };
  }
}
