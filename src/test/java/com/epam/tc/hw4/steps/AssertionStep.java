package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

  @Step("Assert that page title equal to '{homePage}'")
  public void assertTitleEquals(String homePage) {
    assertThat(indexPage.getTitle()).isEqualTo(homePage);
  }

  @Step("Assert that Username '{userNameText}' is logging")
  public void assertThatUserNameDisplayed(String userNameText) {
    assertThat(loginComponent.isUserNameTextDisplayed()).isTrue();
    assertThat(loginComponent.getUserNameText()).isEqualTo(userNameText);
  }

  @Step("Assert that there are items on the header section are displayed, and they have proper texts")
  public void assertHeaderItemsDisplayed(String[] headers) {
    assertAllElementsPresent(headerMenu.getDisplayedHeaders(), headers);
  }

  @Step("Assert that there are '{imagesCount}' images on the Index Page, and they are displayed")
  public void assertImagesAreDisplayed(int imagesCount) {
    List<WebElement> pageImages = indexPage.getImages();
    assertThat(pageImages).hasSize(imagesCount);
    assertThat(pageImages).allSatisfy(WebElement::isDisplayed);
  }

  @Step("Assert that there are texts on the Index Page under icons, and they have proper text")
  public void assertTextUnderIcons(String[] imagesText) {
    assertAllElementsPresent(indexPage.getDisplayedImagesTexts(), imagesText);
  }

  @Step("Check that there is “Frame Button” in the iframe")
  public void assertFrameButtonIsInIframe() {
    assertThat(indexPage.getIframes()).isNotEmpty();
    assertThat(indexPage.isFrameButtonFoundInIframe()).isTrue();
  }

  @Step("Assert that there are items in the Left Section are displayed and they have proper text")
  public void assertLeftSectionItems(String[] leftSectionItems) {
    assertAllElementsPresent(leftMenu.getDisplayedLeftElements(), leftSectionItems);
  }

  @Step("Assert log messages matches expected patterns")
  public void assertLogMessages(String[] logPatterns) {
    assertThat(logComponent.getLogTexts()).allMatch(logText -> Arrays.stream(logPatterns).anyMatch(logText::matches));
  }

  private void assertAllElementsPresent(List<String> validatedList, String[] data) {
    assertThat(validatedList).containsExactly(data);
  }
}
