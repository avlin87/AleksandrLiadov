package com.epam.tc.hw3.data.pages;

import org.testng.annotations.DataProvider;

public class IndexPageData {

  @DataProvider(name = "images text")
  public static Object[][] getImagesTexts() {
    return new Object[][]{
        {"To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…" }
    };
  }
}
