package com.epam.tc.selenide.data.components;

import org.testng.annotations.DataProvider;

public class HeaderMenuData {

  @DataProvider(name = "header data")
  public static Object[][] getHeaderData() {
    return new Object[][]{
        {"HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS" },
        {"HOME",
            "SERVICE",
            "CONTACT FORM",
            "METALS & COLORS" }
    };
  }
}

