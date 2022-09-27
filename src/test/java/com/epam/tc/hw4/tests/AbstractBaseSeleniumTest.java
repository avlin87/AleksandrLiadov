package com.epam.tc.hw4.tests;

import static com.epam.tc.hw4.driver.WebDriverSingleton.getWebDriver;

import com.epam.tc.hw4.driver.WebDriverSingleton;
import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import java.util.concurrent.TimeUnit;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBaseSeleniumTest {

  protected ActionStep actionStep;
  protected AssertionStep assertionStep;

  @BeforeMethod
  public void setUp(ITestContext testContext) {
    getWebDriver().manage().window().maximize();
    getWebDriver().manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);

    actionStep = new ActionStep();
    assertionStep = new AssertionStep();

    testContext.setAttribute("driver", getWebDriver());
  }

  @AfterMethod
  public void clearCookies() {
    getWebDriver().manage().deleteAllCookies();
  }

  @AfterSuite
  public void tearDown() {
    WebDriverSingleton.closeDriver();
  }
}