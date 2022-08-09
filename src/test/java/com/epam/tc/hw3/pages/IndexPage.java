package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.pages.components.HeaderMenu;
import com.epam.tc.hw3.pages.components.LeftMenu;
import com.epam.tc.hw3.pages.components.LoginComponent;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

  private final WebDriver webDriver;

  @Getter
  private final LoginComponent loginComponent;
  @Getter
  private final HeaderMenu headerMenu;
  @Getter
  private final LeftMenu leftMenu;

  @Getter
  @FindBy(css = "div.benefit div.benefit-icon span[class^='icons-benefit']")
  private List<WebElement> images;

  @FindBy(xpath = "//div[@class='benefit']//div[@class='benefit-icon']//span[starts-with(@class,'icons-benefit')]"
      + "//parent::div[@class='benefit-icon']//parent::div[@class='benefit']"
      + "//span[@class='benefit-txt']")
  private List<WebElement> imagesTexts;

  @Getter
  @FindBy(tagName = "iframe")
  private List<WebElement> iframes;

  @Getter
  @FindBy(css = "input[value='Frame Button']")
  private List<WebElement> frameButtons;

  public IndexPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
    loginComponent = PageFactory.initElements(webDriver, LoginComponent.class);
    headerMenu = PageFactory.initElements(webDriver, HeaderMenu.class);
    leftMenu = PageFactory.initElements(webDriver, LeftMenu.class);
  }

  public void open() {
    webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
  }

  public String getTitle() {
    return webDriver.getTitle();
  }

  public List<String> getDisplayedImagesTexts() {
    return imagesTexts.stream()
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  public boolean isFrameButtonFoundInIframe() {
    for (WebElement iframe : iframes) {
      webDriver.switchTo().frame(iframe);
      boolean isFound = !frameButtons.isEmpty();
      switchToOriginalWindow();
      if (isFound) {
        return true;
      }
    }
    return false;
  }

  public void switchToOriginalWindow() {
    webDriver.switchTo().defaultContent();
  }
}