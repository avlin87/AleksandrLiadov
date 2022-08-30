package com.epam.tc.hw5.pages.components;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LogComponent - Page Object for 'Log Component'.
 *
 * @author Aleksandr Liadov
 */
public class LogComponent {

  @Getter
  @FindBy(css = "ul[class='panel-body-list logs'] li")
  private List<WebElement> logElements;

  /**
   * Method form List of text values.
   *
   * @return List<> - String values for Log Component elements
   */
  public List<String> getLogTexts() {
    return logElements.stream()
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }
}
