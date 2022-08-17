package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBaseSeleniumTest {

  protected WebDriver webDriver;

  protected ActionStep actionStep;
  protected AssertionStep assertionStep;

  @BeforeMethod
  public void setUp(ITestContext testContext) {
    webDriver = WebDriverManager.chromedriver().create();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);

    actionStep = new ActionStep(webDriver);
    assertionStep = new AssertionStep(webDriver);

    testContext.setAttribute("driver", webDriver);
  }

  @AfterMethod
  public void tearDown() {
    if (webDriver != null) {
      webDriver.quit();
    }
  }
}