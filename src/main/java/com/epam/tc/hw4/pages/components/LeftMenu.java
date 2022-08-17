package com.epam.tc.hw4.pages.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LeftMenu - Page Object for 'Left Menu' component.
 *
 * @author Aleksandr Liadov
 */
public class LeftMenu {

  @FindBy(css = "ul[class='sidebar-menu left'] li")
  private List<WebElement> leftElements;

  /**
   * Method filters displayed elements and form List of String values.
   *
   * @return List<> - String values for Left Menu Elements
   */
  public List<String> getDisplayedLeftElements() {
    return leftElements.stream()
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }
}