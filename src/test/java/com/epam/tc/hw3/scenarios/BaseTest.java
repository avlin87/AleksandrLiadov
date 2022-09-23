package com.epam.tc.hw3.scenarios;

import static com.epam.tc.hw3.data.DataEnum.INDEX_PAGE_URL;
import static com.epam.tc.hw3.data.DataEnum.PASSWORD;
import static com.epam.tc.hw3.data.DataEnum.USER_NAME;
import static com.epam.tc.hw3.data.DataEnum.USER_NAME_TEXT;
import static com.epam.tc.hw3.utils.PropertiesLoaderTest.getProperty;

import com.epam.tc.hw3.data.DataEnum;
import com.epam.tc.hw3.pages.IndexPage;
import com.epam.tc.hw3.pages.components.HeaderMenu;
import com.epam.tc.hw3.pages.components.LoginComponent;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Map;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  protected WebDriver webDriver;
  protected SoftAssertions softly;
  protected IndexPage indexPage;
  protected LoginComponent loginComponent;
  protected HeaderMenu headerMenu;

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

  protected void navigateToIndexPageAndLogin(Map<DataEnum, String[]> dataMap) {
    indexPage = new IndexPage(webDriver);
    loginComponent = indexPage.getLoginComponent();
    headerMenu = indexPage.getHeaderMenu();

    // 1.	Open test site by URL
    indexPage.open(dataMap.get(INDEX_PAGE_URL)[0]);
    // 2. Assert Browser title
    softly.assertThat(indexPage.getTitle()).isEqualTo("Home Page");
    // 3. Perform login
    loginComponent.login(getProperty(USER_NAME), getProperty(PASSWORD));
    // 4. Assert Username is loggined
    assertUserLogged(loginComponent, getProperty(USER_NAME_TEXT));
  }

  private void assertUserLogged(LoginComponent loginComponent, String userNameText) {
    softly.assertThat(loginComponent.isLogoutButtonDisplayed()).isTrue();
    softly.assertThat(loginComponent.isUserNameTextDisplayed()).isTrue();
    softly.assertThat(loginComponent.getUserNameText()).isEqualTo(userNameText);
  }
}