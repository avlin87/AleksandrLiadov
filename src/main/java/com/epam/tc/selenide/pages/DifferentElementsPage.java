package com.epam.tc.selenide.pages;

import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.tc.selenide.pages.components.LogComponent;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage {

  @Getter
  private final LogComponent logComponent;

  @FindBy(css = "label.label-checkbox:nth-child(1) input[type='checkbox'], label.label-checkbox:nth-child(3) input[type='checkbox']")
  private ElementsCollection checkBoxesOneAndThree;

  @FindBy(css = "label.label-radio:nth-child(4) input[type='radio']")
  private SelenideElement forthRadioButton;

  @FindBy(css = "div.colors select.uui-form-element")
  private SelenideElement colorDropDown;

  @FindBy(css = "div.colors select.uui-form-element option:nth-child(4)")
  private SelenideElement forthColorInDropDown;

  @FindBy(className = "main-content-hg")
  private SelenideElement mainContentHg;

  public DifferentElementsPage() {
    logComponent = page(LogComponent.class);
  }

  @SuppressWarnings("deprecation")
  public void selectCheckboxes() {
    checkBoxesOneAndThree.forEach(SelenideElement::click);
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
