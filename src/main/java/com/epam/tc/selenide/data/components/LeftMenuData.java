package com.epam.tc.selenide.data.components;

import org.testng.annotations.DataProvider;

public class LeftMenuData {

  @DataProvider(name = "left menu data")
  public static Object[][] getLeftMenuData() {
    return new Object[][]{
        {"Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs" },
        {"Home",
            "Metals & Colors",
            "Contact form",
            "Service",
            "Elements packs" }
    };
  }
}