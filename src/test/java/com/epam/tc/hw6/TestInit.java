package com.epam.tc.hw6;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface TestInit {

  @BeforeSuite(alwaysRun = true)
  default void beforeSuite() {
    PageFactory.initSite(JdiSite.class);
  }

  @AfterSuite(alwaysRun = true)
  default void afterSuite() {
    killAllSeleniumDrivers();
  }

  @AfterMethod(alwaysRun = true)
  default void afterMethod() {
    WebDriverFactory.getDriver().manage().deleteAllCookies();
  }
}
