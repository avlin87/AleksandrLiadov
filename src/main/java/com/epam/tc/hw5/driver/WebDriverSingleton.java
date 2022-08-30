package com.epam.tc.hw5.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Objects;
import org.openqa.selenium.WebDriver;

/**
 * WebDriverSingleton - class handles distribution of webDriver.
 *
 * @author Aleksandr Liadov
 */
public class WebDriverSingleton {

  private static WebDriver webDriver;

  private WebDriverSingleton() {
  }

  /**
   * Method create webDriver if it is null and return webDriver.
   *
   * @return WebDriver
   */
  public static WebDriver getWebDriver() {
    String browserName =
        System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
    if (Objects.isNull(webDriver)) {
      webDriver = WebDriverManager.getInstance(browserName).create();
      webDriver.manage().window().maximize();
    }
    return webDriver;
  }

  public static void closeDriver() {
    webDriver.quit();
    webDriver = null;
  }
}
