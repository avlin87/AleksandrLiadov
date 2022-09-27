package com.epam.tc.hw4.listners;

import com.epam.tc.hw4.driver.WebDriverSingleton;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

  @Override
  public void onTestFailure(ITestResult result) {
    WebDriver driver = WebDriverSingleton.getWebDriver();
    attachScreenshot(driver);
  }

  @Attachment(type = "image/png", fileExtension = ".png")
  private byte[] attachScreenshot(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
