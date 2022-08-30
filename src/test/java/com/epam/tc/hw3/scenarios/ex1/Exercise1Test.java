package com.epam.tc.hw3.scenarios.ex1;

import static com.epam.tc.hw3.data.DataEnum.HEADERS;
import static com.epam.tc.hw3.data.DataEnum.IMAGES_TEXTS;
import static com.epam.tc.hw3.data.DataEnum.LEFT_MENU;

import com.epam.tc.hw3.data.DataEnum;
import com.epam.tc.hw3.data.Exercise1Data;
import com.epam.tc.hw3.pages.components.LeftMenu;
import com.epam.tc.hw3.scenarios.BaseTest;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseTest {

  @Test(dataProvider = "Exercise 1", dataProviderClass = Exercise1Data.class)
  public void exercise1(Map<DataEnum, String[]> dataMap) {
    LeftMenu leftMenu = indexPage.getLeftMenu();

    // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
    List<String> displayedHeaders = headerMenu.getDisplayedHeaders();
    assertAllElementsPresent(displayedHeaders, dataMap.get(HEADERS));
    // 6. Assert that there are 4 images on the Index Page, and they are displayed
    List<WebElement> pageImages = indexPage.getImages();
    assertFourElementsDisplayed(pageImages);
    //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
    List<String> imagesTexts = indexPage.getDisplayedImagesTexts();
    assertAllElementsPresent(imagesTexts, dataMap.get(IMAGES_TEXTS));
    //8.	Assert that there is the iframe with “Frame Button” exist
    softly.assertThat(indexPage.getIframes()).isNotEmpty();
    //9.	Switch to the iframe and check that there is “Frame Button” in the iframe
    softly.assertThat(indexPage.isFrameButtonFoundInIframe()).isTrue();
    //10.	Switch to original window back
    indexPage.switchToOriginalWindow();
    //11.	Assert that there are 5 items in the Left Section are displayed and they have proper text
    List<String> displayedLeftMenuElements = leftMenu.getDisplayedLeftElements();
    assertAllElementsPresent(displayedLeftMenuElements, dataMap.get(LEFT_MENU));

    //check result
    softly.assertAll();
  }

  private void assertAllElementsPresent(List<String> validatedList, String[] data) {
    softly.assertThat(validatedList).hasSize(data.length);
    softly.assertThat(validatedList).contains(data);
  }

  private void assertFourElementsDisplayed(List<WebElement> elements) {
    softly.assertThat(elements).hasSize(4);
    softly.assertThat(elements).allSatisfy(WebElement::isDisplayed);
  }
}
