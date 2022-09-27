package com.epam.tc.hw4.steps;

import io.qameta.allure.Step;

public class ActionStep extends AbstractStep {

  @Step("Open jdi-testing Index Page")
  public void openIndexPage() {
    indexPage.open();
  }

  @Step("login")
  public void login(String login, String password) {
    loginComponent.login(login, password);
  }

  @Step("Switch to original window back")
  public void switchToOriginalWindow() {
    indexPage.switchToOriginalWindow();
  }

  @Step("Open through the header menu Service -> Different Elements Page")
  public void navigateToDifferentElementsPage() {
    headerMenu.navigateToDifferentElementsPage();
  }

  @Step("Select checkboxes")
  public void selectCheckboxes() {
    differentElementsPage.selectCheckboxes();
  }

  @Step("Select radio button")
  public void selectRadioButton() {
    differentElementsPage.selectRadioButton();
  }

  @Step("Select in dropdown value")
  public void selectInDropDown() {
    differentElementsPage.selectInDropDown();
  }
}
