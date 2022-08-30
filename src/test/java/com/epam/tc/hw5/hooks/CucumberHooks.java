package com.epam.tc.hw5.hooks;

import com.epam.tc.hw5.driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

  @Before
  public void setUp() {
    WebDriverSingleton.getWebDriver();
  }

  @After
  public void tearDown(Scenario scenario) throws IllegalMonitorStateException {
    WebDriverSingleton.closeDriver();
  }
}
