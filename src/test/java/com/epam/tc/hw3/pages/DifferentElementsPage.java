package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.pages.components.LogComponent;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {

  @Getter
  private final LogComponent logComponent;

  @FindBy(css = "label.label-checkbox:nth-child(1) input[type='checkbox'], label.label-checkbox:nth-child(3) input[type='checkbox']")
  private List<WebElement> checkBoxesOneAndThree;

  @FindBy(css = "label.label-radio:nth-child(4) input[type='radio']")
  private WebElement forthRadioButton;

  @FindBy(css = "div.colors select.uui-form-element")
  private WebElement colorDropDown;

  @FindBy(css = "div.colors select.uui-form-element option:nth-child(4)")
  private WebElement forthColorInDropDown;

  @FindBy(className = "main-content-hg")
  private WebElement mainContentHg;

  public DifferentElementsPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    logComponent = PageFactory.initElements(webDriver, LogComponent.class);
  }

  public void selectCheckboxes() {
    checkBoxesOneAndThree.forEach(WebElement::click);
  }

  public void selectRadioButton() {
    forthRadioButton.click();
  }

  public void selectInDropDown() {
    colorDropDown.click();
    forthColorInDropDown.click();
    mainContentHg.click();
  }
}
