package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.driver.WebDriverSingleton;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.IndexPage;
import com.epam.tc.hw5.pages.UserTablePage;
import com.epam.tc.hw5.pages.components.HeaderMenu;
import com.epam.tc.hw5.pages.components.LogComponent;
import com.epam.tc.hw5.pages.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for Steps definitions.
 *
 * @author Aleksandr Liadov
 */
public abstract class AbstractBaseStepDef {

  protected IndexPage indexPage;
  protected LoginComponent loginComponent;
  protected HeaderMenu headerMenu;
  protected UserTablePage userTablePage;
  protected DifferentElementsPage differentElementsPage;
  protected LogComponent logComponent;

  protected AbstractBaseStepDef() {
    WebDriver webDriver = WebDriverSingleton.getWebDriver();

    indexPage = PageFactory.initElements(webDriver, IndexPage.class);
    loginComponent = PageFactory.initElements(webDriver, LoginComponent.class);
    headerMenu = PageFactory.initElements(webDriver, HeaderMenu.class);
    userTablePage = PageFactory.initElements(webDriver, UserTablePage.class);
    differentElementsPage = PageFactory.initElements(webDriver, DifferentElementsPage.class);
    logComponent = PageFactory.initElements(webDriver, LogComponent.class);
  }

}
