package com.epam.tc.hw5.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginComponent - Page Object for 'Login Component'.
 *
 * @author Aleksandr Liadov
 */
public class LoginComponent {

  @FindBy(css = "li[class='dropdown uui-profile-menu'] a.dropdown-toggle")
  private WebElement dropdownToggle;

  @FindBy(id = "name")
  private WebElement nameField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @FindBy(id = "user-name")
  private WebElement userNameText;

  /**
   * Method open 'login form' (dropdownToggle). Populate credentials and click Login button.
   *
   * @param username String - user name
   * @param password String - password
   */
  public void login(String username, String password) {
    dropdownToggle.click();
    nameField.sendKeys(username);
    passwordField.sendKeys(password);
    loginButton.click();
  }

  public String getUserNameText() {
    return userNameText.getText();
  }
}
