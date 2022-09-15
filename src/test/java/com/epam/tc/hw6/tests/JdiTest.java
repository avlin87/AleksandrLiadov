package com.epam.tc.hw6.tests;

import static com.epam.tc.hw6.data.JdiTestData.ROMAN;

import com.epam.tc.hw6.JdiSite;
import com.epam.tc.hw6.TestInit;
import org.testng.annotations.Test;

public class JdiTest implements TestInit {

  @Test
  public void userCanSubmitMetalsColors() {
    JdiSite.open();
    JdiSite.login(ROMAN);
    JdiSite.checkUserLoggedIn(ROMAN);

    JdiSite.navigateToMetalsColorsPage();
    JdiSite.fillFormMetalsColors();
    JdiSite.submitFormMetalsColors();

    JdiSite.checkResultSection();
  }
}