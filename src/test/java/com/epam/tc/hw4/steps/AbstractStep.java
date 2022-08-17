package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.IndexPage;
import com.epam.tc.hw4.pages.components.HeaderMenu;
import com.epam.tc.hw4.pages.components.LeftMenu;
import com.epam.tc.hw4.pages.components.LogComponent;
import com.epam.tc.hw4.pages.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractStep {

  protected IndexPage indexPage;
  protected LoginComponent loginComponent;
  protected HeaderMenu headerMenu;
  protected LeftMenu leftMenu;

  protected DifferentElementsPage differentElementsPage;
  protected LogComponent logComponent;

  protected AbstractStep(WebDriver webDriver) {
    indexPage = PageFactory.initElements(webDriver, IndexPage.class);
    loginComponent = PageFactory.initElements(webDriver, LoginComponent.class);
    headerMenu = PageFactory.initElements(webDriver, HeaderMenu.class);
    leftMenu = PageFactory.initElements(webDriver, LeftMenu.class);

    differentElementsPage = PageFactory.initElements(webDriver, DifferentElementsPage.class);
    logComponent = PageFactory.initElements(webDriver, LogComponent.class);
  }
}