package com.epam.tc.selenide.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class LogComponent {

  @Getter
  @FindBy(css = "ul[class='panel-body-list logs'] li")
  private ElementsCollection logElements;

  @SuppressWarnings("deprecation")
  public SelenideElement isMatchFoundInLog(String logPattern) {
    return logElements.stream()
        .filter(selenideElement -> selenideElement.getText().matches(logPattern))
        .collect(Collectors.toList())
        .get(0);
  }
}
