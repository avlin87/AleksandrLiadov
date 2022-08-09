package com.epam.tc.hw3.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginComponent {

  @FindBy(css = "li[class='dropdown uui-profile-menu'] a.dropdown-toggle")
  private WebElement dropdownToggle;

  @FindBy(id = "name")
  private WebElement nameField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @FindBy(css = "div.logout button[class='uui-button dark-blue btn-login']")
  private WebElement logoutButton;

  @FindBy(id = "user-name")
  private WebElement userNameText;

  public void login(String username, String password) {
    dropdownToggle.click();
    nameField.sendKeys(username);
    passwordField.sendKeys(password);
    loginButton.click();
  }

  public boolean isLogoutButtonDisplayed() {
    return logoutButton.isDisplayed();
  }

  public boolean isUserNameTextDisplayed() {
    return userNameText.isDisplayed();
  }

  public String getUserNameText() {
    return userNameText.getText();
  }
}