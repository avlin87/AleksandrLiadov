package com.epam.tc.hw2;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractLoginHandler extends AbstractWebDriverHandler {

  protected void openTestSiteByUrl(SoftAssertions softly) {
    String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    webDriver.get(URL);
    softly.assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
  }

  protected void assertBrowserTitle(SoftAssertions softly) {
    softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
  }

  protected void performLogin(SoftAssertions softly) {
    webDriver.findElement(By.cssSelector("li[class='dropdown uui-profile-menu'] a.dropdown-toggle"))
        .click();
    webDriver.findElement(By.id("name"))
        .sendKeys("Roman");
    webDriver.findElement(By.id("password"))
        .sendKeys("Jdi1234");
    webDriver.findElement(By.id("login-button"))
        .click();
    WebElement logoutButton =
        webDriver.findElement(By.cssSelector("div.logout button[class='uui-button dark-blue btn-login']"));

    softly.assertThat(logoutButton.isDisplayed()).isTrue();
  }

  protected void assertUserLogged(SoftAssertions softly) {
    WebElement userName = webDriver.findElement(By.id("user-name"));
    softly.assertThat(userName.isDisplayed()).isTrue();
    softly.assertThat(userName.getText()).isEqualTo("ROMAN IOVLEV");
  }

}
