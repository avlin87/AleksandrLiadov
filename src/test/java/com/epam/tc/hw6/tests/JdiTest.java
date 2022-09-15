package com.epam.tc.hw6.tests;

import static com.epam.tc.hw6.data.JdiTestData.ROMAN;

import com.epam.tc.hw6.JdiSite;
import com.epam.tc.hw6.TestInit;
import com.epam.tc.hw6.data.MetalsColorsDataProvider;
import com.epam.tc.hw6.entities.MetalsColorsInfo;
import org.testng.annotations.Test;

public class JdiTest implements TestInit {

  @Test(dataProvider = "Metals Colors From Json",
      dataProviderClass = MetalsColorsDataProvider.class)
  public void userCanSubmitMetalsColors(MetalsColorsInfo metalsColorsInfo) {
    JdiSite.open();
    JdiSite.login(ROMAN);
    JdiSite.checkUserLoggedIn(ROMAN);

    JdiSite.navigateToMetalsColorsPage();
    JdiSite.fillFormMetalsColors(metalsColorsInfo);
    JdiSite.submitFormMetalsColors();

    JdiSite.checkResultSection(metalsColorsInfo);
  }
}