package com.epam.tc.selenide.base;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.epam.tc.selenide.pages.components.LoginComponent;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class SelenideTestBase {

  @BeforeSuite
  public void beforeSuit() {
    Configuration.browser = "chrome";
    Configuration.downloadsFolder = "target\\selenide\\downloads";
    Configuration.reportsFolder = "target\\selenide\\reports";
    try {
      Selenide.open("data");
    } catch (Exception ignored) {
    }
  }

  @AfterMethod
  public void clearCash() {
    clearBrowserCookies();
    clearBrowserLocalStorage();
  }

  protected void assertUserLogged(LoginComponent loginComponent, String userNameText) {
    loginComponent.getLogoutButton().shouldBe(visible);
    loginComponent.getUserNameText().shouldBe(visible)
        .shouldHave(text(userNameText));
  }
}
