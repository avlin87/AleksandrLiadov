package com.epam.tc.hw3.pages.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu {

  @FindBy(css = "ul[class='sidebar-menu left'] li")
  private List<WebElement> leftElements;

  public List<String> getDisplayedLeftElements() {
    return leftElements.stream()
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }
}