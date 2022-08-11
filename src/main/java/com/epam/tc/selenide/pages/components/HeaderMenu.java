package com.epam.tc.selenide.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu {

  @Getter
  @FindBy(css = "header ul[class='uui-navigation nav navbar-nav m-l8']>li>a")
  private ElementsCollection headerElements;

  @FindBy(css = "header ul[class='uui-navigation nav navbar-nav m-l8'] li a.dropdown-toggle")
  private SelenideElement headerServiceDropDown;

  @FindBy(css = "header ul[class='uui-navigation nav navbar-nav m-l8'] li ul.dropdown-menu li a[href='different-elements.html']")
  private SelenideElement differentElementsItem;

  @SuppressWarnings("deprecation")
  public List<String> getDisplayedHeaders() {
    return headerElements.stream()
        .filter(SelenideElement::isDisplayed)
        .map(SelenideElement::getText)
        .collect(Collectors.toList());
  }

  public void navigateToDifferentElementsPage() {
    headerServiceDropDown.click();
    differentElementsItem.click();
  }
}