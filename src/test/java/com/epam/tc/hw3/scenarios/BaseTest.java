package com.epam.tc.hw3.scenarios;

import com.epam.tc.hw3.pages.components.LoginComponent;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  protected WebDriver webDriver;
  protected SoftAssertions softly;

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
    softly = new SoftAssertions();
  }

  @AfterClass
  public void tearDown() {
    if (webDriver != null) {
      webDriver.quit();
    }
  }

  @AfterMethod
  public void clearCookies() {
    if (webDriver != null) {
      webDriver.manage().deleteAllCookies();
    }
  }

  protected void assertUserLogged(LoginComponent loginComponent, String userNameText) {
    softly.assertThat(loginComponent.isLogoutButtonDisplayed()).isTrue();
    softly.assertThat(loginComponent.isUserNameTextDisplayed()).isTrue();
    softly.assertThat(loginComponent.getUserNameText()).isEqualTo(userNameText);
  }
}