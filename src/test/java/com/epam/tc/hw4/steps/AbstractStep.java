package com.epam.tc.hw4.steps;

import static com.epam.tc.hw4.driver.WebDriverSingleton.getWebDriver;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.IndexPage;
import com.epam.tc.hw4.pages.components.HeaderMenu;
import com.epam.tc.hw4.pages.components.LeftMenu;
import com.epam.tc.hw4.pages.components.LogComponent;
import com.epam.tc.hw4.pages.components.LoginComponent;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractStep {

  protected IndexPage indexPage;
  protected LoginComponent loginComponent;
  protected HeaderMenu headerMenu;
  protected LeftMenu leftMenu;

  protected DifferentElementsPage differentElementsPage;
  protected LogComponent logComponent;

  protected AbstractStep() {
    indexPage = PageFactory.initElements(getWebDriver(), IndexPage.class);
    loginComponent = PageFactory.initElements(getWebDriver(), LoginComponent.class);
    headerMenu = PageFactory.initElements(getWebDriver(), HeaderMenu.class);
    leftMenu = PageFactory.initElements(getWebDriver(), LeftMenu.class);

    differentElementsPage = PageFactory.initElements(getWebDriver(), DifferentElementsPage.class);
    logComponent = PageFactory.initElements(getWebDriver(), LogComponent.class);
  }
}