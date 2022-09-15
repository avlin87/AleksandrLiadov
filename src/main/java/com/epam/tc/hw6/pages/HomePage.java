package com.epam.tc.hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.tc.hw6.entities.User;
import com.epam.tc.hw6.forms.LoginForm;

/**
 * HomePage - Page object for 'Home Page'.
 *
 * @author Aleksandr Liadov
 */

@Url("/index.html")
public class HomePage extends WebPage {

  @UI("span[id=user-name]:not([class=hidden])")
  public Label userName;

  @UI("#user-icon")
  public Icon userIcon;

  @UI("ul[class='uui-navigation nav navbar-nav m-l8'] a[href='metals-colors.html']")
  public Link metalsColors;

  public LoginForm loginForm;

  public void login(User user) {
    userIcon.click();
    loginForm.login(user);
  }

  public void checkUserLoggedIn(User user) {
    userName.has().text(user.getFullName());
  }

  public void navigateToMetalsColorsPage() {
    metalsColors.click();
  }
}