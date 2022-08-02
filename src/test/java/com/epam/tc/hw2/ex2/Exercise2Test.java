package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.AbstractLoginHandler;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise2Test extends AbstractLoginHandler {

  @Test
  public void exercise2() {
    SoftAssertions softly = new SoftAssertions();

    // 1.	Open test site by URL
    openTestSiteByUrl(softly);

    // 2. Assert Browser title
    assertBrowserTitle(softly);

    // 3. Perform login
    performLogin(softly);

    // 4. Assert Username is loggined
    assertUserLogged(softly);

    // 5. Open through the header menu Service -> Different Elements Page
    webDriver.findElement(By.cssSelector("header ul[class='uui-navigation nav navbar-nav m-l8'] li a.dropdown-toggle"))
        .click();
    webDriver.findElement(By.cssSelector(
            "header ul[class='uui-navigation nav navbar-nav m-l8'] li ul.dropdown-menu li a[href='different-elements.html']"))
        .click();

    //6.	Select checkboxes
    List<WebElement> checkboxes = webDriver.findElements(By.cssSelector(
        "label.label-checkbox:nth-child(1) input[type='checkbox'], label.label-checkbox:nth-child(3) input[type='checkbox']"));
    checkboxes.forEach(WebElement::click);
    checkboxes.forEach(webElement -> softly.assertThat(webElement.isSelected()).isTrue());

    //7.	Select radio
    WebElement radioButton = webDriver.findElement(
        By.cssSelector("label.label-radio:nth-child(4) input[type='radio']"));
    radioButton.click();
    softly.assertThat(radioButton.isSelected()).isTrue();

    //8.	Select in dropdown
    webDriver.findElement(By.cssSelector("div.colors select.uui-form-element"))
        .click();
    webDriver.findElement(By.cssSelector("div.colors select.uui-form-element option:nth-child(4)"))
        .click();
    webDriver.findElement(By.className("main-content-hg")).click();

    //9.	Assert that
    List<String> logMessages = webDriver.findElements(By.cssSelector("ul[class='panel-body-list logs'] li"))
        .stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());

    //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    boolean isWaterLogPresent = logMessages.stream()
        .anyMatch(logMessage -> logMessage.matches("^(\\d{2}.?){3}(?i)(Water: condition changed to true)$"));
    boolean isWindLogPresent = logMessages.stream()
        .anyMatch(logMessage -> logMessage.matches("^(\\d{2}.?){3}(?i)(Wind: condition changed to true)$"));
    softly.assertThat(isWaterLogPresent & isWindLogPresent).isTrue();

    //•	for radio button there is a log row and value is corresponded to the status of radio button
    boolean isSelenLogPresent = logMessages.stream()
        .anyMatch(logMessage -> logMessage.matches("^(\\d{2}.?){3}(?i)(metal: value changed to Selen)$"));
    softly.assertThat(isSelenLogPresent).isTrue();

    //•	for dropdown there is a log row and value is corresponded to the selected value.
    boolean isColorLogPresent = logMessages.stream()
        .anyMatch(logMessage -> logMessage.matches("^(\\d{2}.?){3}(?i)(Colors: value changed to Yellow)$"));
    softly.assertThat(isColorLogPresent).isTrue();

    softly.assertAll();
  }
}