package com.epam.tc.selenide.pages;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.tc.selenide.pages.components.HeaderMenu;
import com.epam.tc.selenide.pages.components.LeftMenu;
import com.epam.tc.selenide.pages.components.LoginComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

  private final WebDriver webDriver = getWebDriver();

  @Getter
  private final LoginComponent loginComponent;
  @Getter
  private final HeaderMenu headerMenu;
  @Getter
  private final LeftMenu leftMenu;

  @Getter
  @FindBy(css = "title")
  private SelenideElement title;

  @Getter
  @FindBy(css = "div.benefit div.benefit-icon span[class^='icons-benefit']")
  private ElementsCollection images;

  @Getter
  @FindBy(xpath = "//div[@class='benefit']//div[@class='benefit-icon']//span[starts-with(@class,'icons-benefit')]"
      + "//parent::div[@class='benefit-icon']//parent::div[@class='benefit']"
      + "//span[@class='benefit-txt']")
  private ElementsCollection imagesTexts;

  @Getter
  @FindBy(tagName = "iframe")
  private ElementsCollection iframes;

  @Getter
  @FindBy(css = "input[value='Frame Button']")
  private SelenideElement frameButton;

  public IndexPage() {
    loginComponent = page(LoginComponent.class);
    headerMenu = page(HeaderMenu.class);
    leftMenu = page(LeftMenu.class);
  }

  public SelenideElement isFrameButtonFoundInIframe() {
    for (SelenideElement iframe : iframes) {
      webDriver.switchTo().frame(iframe);
      boolean isFound = frameButton.isDisplayed();
      if (isFound) {
        return frameButton;
      }
      switchToOriginalWindow();
    }
    return null;
  }

  public void switchToOriginalWindow() {
    webDriver.switchTo().defaultContent();
  }

  public void openPage() {
    open("https://jdi-testing.github.io/jdi-light/index.html");
    getWebDriver().manage().window().maximize();
  }
}