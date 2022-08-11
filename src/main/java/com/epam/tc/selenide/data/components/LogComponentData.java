package com.epam.tc.selenide.data.components;

import org.testng.annotations.DataProvider;

public class LogComponentData {

  @DataProvider(name = "log component data")
  public static Object[][] getLogComponentData() {
    return new Object[][]{
        {"^(\\d{2}.?){3}(?i)(Water: condition changed to true)$",
            "^(\\d{2}.?){3}(?i)(Wind: condition changed to true)$",
            "^(\\d{2}.?){3}(?i)(metal: value changed to Selen)$",
            "^(\\d{2}.?){3}(?i)(Colors: value changed to Yellow)$" }
    };
  }

}
