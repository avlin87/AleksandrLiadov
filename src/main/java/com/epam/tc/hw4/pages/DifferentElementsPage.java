package com.epam.tc.hw4.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * DifferentElementsPage - Page object for 'Different Elements Page'.
 *
 * @author Aleksandr Liadov
 */
public class DifferentElementsPage {

  @FindBy(css = "label.label-checkbox:nth-child(1) input[type='checkbox'], "
      + "label.label-checkbox:nth-child(3) input[type='checkbox']")
  private List<WebElement> checkBoxesOneAndThree;

  @FindBy(css = "label.label-radio:nth-child(4) input[type='radio']")
  private WebElement forthRadioButton;

  @FindBy(css = "div.colors select.uui-form-element")
  private WebElement colorDropDown;

  @FindBy(css = "div.colors select.uui-form-element option:nth-child(4)")
  private WebElement forthColorInDropDown;

  @FindBy(className = "main-content-hg")
  private WebElement mainContentHg;

  public void selectCheckboxes() {
    checkBoxesOneAndThree.forEach(WebElement::click);
  }

  public void selectRadioButton() {
    forthRadioButton.click();
  }

  /**
   * Method perform selection of forth color (Yellow) from drop down menu.
   */
  public void selectInDropDown() {
    colorDropDown.click();
    forthColorInDropDown.click();
    mainContentHg.click();
  }
}
