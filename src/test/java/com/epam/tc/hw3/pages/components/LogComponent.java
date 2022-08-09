package com.epam.tc.hw3.pages.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogComponent {

  @FindBy(css = "ul[class='panel-body-list logs'] li")
  private List<WebElement> logElements;

  public boolean isMatchFoundInLog(String logPattern) {
    return logElements.stream()
        .map(WebElement::getText)
        .anyMatch(logMessage -> logMessage.matches(logPattern));
  }
}
