package com.epam.tc.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

/**
 * Action definitions class.
 *
 * @author Aleksandr Liadov
 */
public class ActionStepDef extends AbstractBaseStepDef {

  @When("I click on {string} button in Header")
  public void clickOnHeaderItem(String headerItem) {
    headerMenu.navigateToPage(headerItem);
  }

  @And("I click on {string} button in Service dropdown")
  public void clickOnButtonInServiceDropdown(String serviceItem) {
    headerMenu.navigateToPage(serviceItem);
  }

  @And("I select {string} checkbox")
  public void selectCheckbox(String checkBoxName) {
    differentElementsPage.selectCheckbox(checkBoxName);
  }

  @And("I select {string} radiobutton")
  public void selectRadiobutton(String radiobuttonName) {
    differentElementsPage.selectRadioButton(radiobuttonName);
  }

  @And("I select {string} in dropdown")
  public void selectInDropdown(String dropdownValue) {
    differentElementsPage.selectInDropDown(dropdownValue);
  }

  @When("I select {string} checkbox for {string}")
  public void selectVipCheckboxFor(String checkboxName, String userName) {
    userTablePage.selectVipCheckboxFor(checkboxName, userName);
  }
}
