package com.epam.tc.selenide.pages.components;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class LeftMenu {

  @Getter
  @FindBy(css = "ul[class='sidebar-menu left']>li")
  private ElementsCollection leftElements;

  /*public List<String> getDisplayedLeftElements() {
    return leftElements.stream()
        .filter(SelenideElement::isDisplayed)
        .map(SelenideElement::getText)
        .collect(Collectors.toList());
  }*/
}