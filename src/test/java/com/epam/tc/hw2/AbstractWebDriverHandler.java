package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class AbstractWebDriverHandler {

  protected WebDriver webDriver;

  @BeforeClass
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
    webDriver.manage()
        .window()
        .maximize();
    webDriver.manage()
        .timeouts()
        .implicitlyWait(Duration.ofSeconds(3));
  }

  @AfterClass
  public void tearDown() {
    webDriver.quit();
  }
}
