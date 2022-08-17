package com.epam.tc.hw4.dataproviders.pages;

import org.testng.annotations.DataProvider;

/**
 * IndexPageData - Data Provider for 'Index Page'.
 *
 * @author Aleksandr Liadov
 */
public class IndexPageData {

  /**
   * Method returns expected texts placed under images on 'Index Page'.
   *
   * @return Object[][] - data provider
   */
  @DataProvider(name = "images text")
  public static Object[][] getImagesTexts() {
    return new Object[][]{
        {"To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and"
                + "\nsome external projects),\nwish to get more…"}
    };
  }
}
