package com.epam.tc.hw4.pages;

import static com.epam.tc.hw4.driver.WebDriverSingleton.getWebDriver;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * IndexPage - Page Object for 'Index Page'.
 *
 * @author Aleksandr Liadov
 */
public class IndexPage {

  @Getter
  @FindBy(css = "div.benefit div.benefit-icon span[class^='icons-benefit']")
  private List<WebElement> images;

  @FindBy(xpath = "//div[@class='benefit']//div[@class='benefit-icon']"
      + "//span[starts-with(@class,'icons-benefit')]"
      + "//parent::div[@class='benefit-icon']//parent::div[@class='benefit']"
      + "//span[@class='benefit-txt']")
  private List<WebElement> imagesTexts;

  @Getter
  @FindBy(tagName = "iframe")
  private List<WebElement> iframes;

  @Getter
  @FindBy(css = "input[value='Frame Button']")
  private List<WebElement> frameButtons;

  public void open() {
    getWebDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
  }

  public String getTitle() {
    return getWebDriver().getTitle();
  }

  /**
   * Method filters displayed elements and return list of text values.
   *
   * @return List<> - String values
   */
  public List<String> getDisplayedImagesTexts() {
    return imagesTexts.stream()
        .filter(Objects::nonNull)
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  /**
   * Method looks over found iframes. Return true once iframe with 'Frame Button' found. Else false.
   *
   * @return boolean - search result for 'Frame Button'
   */
  public boolean isFrameButtonFoundInIframe() {
    for (WebElement iframe : iframes) {
      getWebDriver().switchTo().frame(iframe);
      boolean isFound = !frameButtons.isEmpty();
      switchToOriginalWindow();
      if (isFound) {
        return true;
      }
    }
    return false;
  }

  public void switchToOriginalWindow() {
    getWebDriver().switchTo().defaultContent();
  }
}