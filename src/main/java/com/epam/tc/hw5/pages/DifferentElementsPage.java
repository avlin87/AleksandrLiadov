package com.epam.tc.hw5.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * DifferentElementsPage - Page object for 'Different Elements Page'.
 *
 * @author Aleksandr Liadov
 */
public class DifferentElementsPage {

  @FindBy(css = "label.label-checkbox")
  private List<WebElement> checkBoxes;

  @FindBy(css = "label.label-radio")
  private List<WebElement> radioButtons;

  @FindBy(css = "div.colors select.uui-form-element")
  private WebElement colorDropDown;

  @FindBy(css = "div.colors select.uui-form-element option")
  private List<WebElement> dropDownValues;

  @FindBy(className = "main-content-hg")
  private WebElement mainContentHg;

  /**
   * Method finds checkbox element with specified name. Click on checkbox in case it exists.
   *
   * @param nameOfCheckBox - String checkbox name
   */
  public void selectCheckbox(String nameOfCheckBox) {
    Optional<WebElement> checkbox = checkBoxes.stream()
        .filter(webElement -> webElement.getText().matches(nameOfCheckBox))
        .map(webElement -> webElement.findElement(By.cssSelector("input[type='checkbox']")))
        .findFirst();
    assertThat(checkbox.isPresent())
        .as("Checkbox '" + nameOfCheckBox + "' not found")
        .isTrue();
    checkbox.get().click();
  }

  /**
   * Method finds radioButton element with specified name. Click on radiobutton in case it exists.
   *
   * @param radiobuttonName - String radiobutton name
   */
  public void selectRadioButton(String radiobuttonName) {
    Optional<WebElement> radioButton = radioButtons.stream()
        .filter(webElement -> webElement.getText().matches(radiobuttonName))
        .map(webElement -> webElement.findElement(By.cssSelector("input[type='radio']")))
        .findFirst();
    assertThat(radioButton.isPresent())
        .as("Radiobutton '" + radiobuttonName + "' not found")
        .isTrue();
    radioButton.get().click();
  }

  /**
   * Method find specified dropdownValue in 'colors' field. Click on it in case color exists.
   *
   * @param dropdownValue - String name of color.
   */
  public void selectInDropDown(String dropdownValue) {
    colorDropDown.click();
    Optional<WebElement> dropdownElement = dropDownValues.stream()
        .filter(webElement -> webElement.getText().matches(dropdownValue))
        .findFirst();
    assertThat(dropdownElement.isPresent())
        .as("Dropdown value '" + dropdownValue + "' not found")
        .isTrue();
    dropdownElement.get().click();
    mainContentHg.click();
  }
}
