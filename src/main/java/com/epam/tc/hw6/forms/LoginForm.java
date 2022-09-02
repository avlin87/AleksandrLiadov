package com.epam.tc.hw6.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw6.entities.User;

/**
 * LoginForm - login form with credentials fields.
 *
 * @author Aleksandr Liadov
 */
public class LoginForm extends Form<User> {

  @UI("#name")
  public TextField name;

  @UI("#password")
  public TextField password;

  @UI("#login-button")
  public Button submit;
}
