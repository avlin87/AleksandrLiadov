package com.epam.tc.selenide.pages.components;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class LoginComponent {

  @FindBy(css = "li[class='dropdown uui-profile-menu'] a.dropdown-toggle")
  private SelenideElement dropdownToggle;

  @FindBy(id = "name")
  private SelenideElement nameField;

  @FindBy(id = "password")
  private SelenideElement passwordField;

  @FindBy(id = "login-button")
  private SelenideElement loginButton;

  @Getter
  @FindBy(css = "div.logout button[class='uui-button dark-blue btn-login']")
  private SelenideElement logoutButton;

  @Getter
  @FindBy(id = "user-name")
  private SelenideElement userNameText;

  public void login(String username, String password) {
    dropdownToggle.click();
    nameField.sendKeys(username);
    passwordField.sendKeys(password);
    loginButton.click();
  }
}