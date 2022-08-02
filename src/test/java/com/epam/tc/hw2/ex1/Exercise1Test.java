package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AbstractLoginHandler;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1Test extends AbstractLoginHandler {

  @Test
  public void exercise1() {
    SoftAssertions softly = new SoftAssertions();

    // 1.	Open test site by URL
    openTestSiteByUrl(softly);

    // 2. Assert Browser title
    assertBrowserTitle(softly);

    // 3. Perform login
    performLogin(softly);

    // 4. Assert Username is loggined
    assertUserLogged(softly);

    // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
    int expectedHeadersSize = 4;
    String[] expectedHeaders = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    assertHeadersDisplayed(softly, expectedHeadersSize, expectedHeaders);

    // 6. Assert that there are 4 images on the Index Page, and they are displayed
    int expectedImagesSize = 4;
    assertImagesDisplayed(softly, expectedImagesSize);

    //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
    int expectedImagesTextsSize = 4;
    String[] expectedTexts = {"To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
    assertImagesTextsDisplayed(softly, expectedImagesTextsSize, expectedTexts);

    //8.	Assert that there is the iframe with “Frame Button” exist
    List<WebElement> iframeList = webDriver.findElements(By.tagName("iframe"));
    softly.assertThat(iframeList).isNotEmpty();

    //9.	Switch to the iframe and check that there is “Frame Button” in the iframe
    boolean isIframeWithFrameButtonExist = false;
    for (WebElement frame : iframeList) {
      webDriver.switchTo().frame(frame);
      boolean isFrameButtonFound = !webDriver.findElements(By.cssSelector("input[value='Frame Button']")).isEmpty();

      //10.	Switch to original window back
      webDriver.switchTo().defaultContent();
      if (isFrameButtonFound) {
        isIframeWithFrameButtonExist = true;
        break;
      }
    }
    softly.assertThat(isIframeWithFrameButtonExist).isTrue();

    //11.	Assert that there are 5 items in the Left Section are displayed and they have proper text
    int expectedLeftSectionItemsSize = 5;
    String[] expectedLeftSectionItemsTexts = {"Home",
        "Contact form",
        "Service",
        "Metals & Colors",
        "Elements packs"};
    assertLeftItemsDisplayed(softly, expectedLeftSectionItemsSize, expectedLeftSectionItemsTexts);

    softly.assertAll();
  }

  private void assertHeadersDisplayed(SoftAssertions softly, int expectedHeadersSize, String[] expectedHeaders) {
    assertDisplayedElementsSizeAndText(
        By.cssSelector("header ul[class='uui-navigation nav navbar-nav m-l8'] li a"),
        softly,
        expectedHeadersSize,
        expectedHeaders);
  }

  private void assertImagesDisplayed(SoftAssertions softly, int expectedImagesSize) {
    List<WebElement> webElements =
        webDriver.findElements(By.cssSelector("div.benefit div.benefit-icon span[class^='icons-benefit']"));

    softly.assertThat(webElements).hasSize(expectedImagesSize);
    softly.assertThat(webElements).allSatisfy(WebElement::isDisplayed);
  }

  private void assertImagesTextsDisplayed(SoftAssertions softly, int expectedImagesTextsSize, String[] expectedTexts) {
    assertDisplayedElementsSizeAndText(
        By.xpath("//div[@class='benefit']//div[@class='benefit-icon']//span[starts-with(@class,'icons-benefit')]"
            + "//parent::div[@class='benefit-icon']//parent::div[@class='benefit']"
            + "//span[@class='benefit-txt']"),
        softly,
        expectedImagesTextsSize,
        expectedTexts);
  }

  private void assertLeftItemsDisplayed(SoftAssertions softly, int expectedLeftSectionItemsSize,
      String[] expectedLeftSectionItemsTexts) {
    assertDisplayedElementsSizeAndText(
        By.cssSelector("ul[class='sidebar-menu left'] li"),
        softly,
        expectedLeftSectionItemsSize,
        expectedLeftSectionItemsTexts);
  }

  private void assertDisplayedElementsSizeAndText(By by, SoftAssertions softly, int expectedSize,
      String[] expectedTexts) {
    List<String> texts = webDriver.findElements(by)
        .stream()
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .collect(Collectors.toList());

    softly.assertThat(texts).hasSize(expectedSize);
    softly.assertThat(texts).contains(expectedTexts);
  }
}
