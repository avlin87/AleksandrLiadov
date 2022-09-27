package com.epam.tc.hw4.tests.ex1;

import static com.epam.tc.hw4.dataproviders.DataEnum.HEADERS;
import static com.epam.tc.hw4.dataproviders.DataEnum.IMAGES_TEXTS;
import static com.epam.tc.hw4.dataproviders.DataEnum.LEFT_MENU;
import static com.epam.tc.hw4.dataproviders.DataEnum.PASSWORD;
import static com.epam.tc.hw4.dataproviders.DataEnum.USER_NAME;
import static com.epam.tc.hw4.dataproviders.DataEnum.USER_NAME_TEXT;
import static com.epam.tc.hw4.utils.PropertiesLoaderTest.getProperty;

import com.epam.tc.hw4.dataproviders.DataEnum;
import com.epam.tc.hw4.dataproviders.Exercise1Data;
import com.epam.tc.hw4.listners.AllureListener;
import com.epam.tc.hw4.tests.AbstractBaseSeleniumTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.Map;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Exercise 1")
@Story("Index Page content")
@Listeners({AllureListener.class})
public class Exercise1Test extends AbstractBaseSeleniumTest {

  @Test(description = "Test Index Page content",
      dataProvider = "Exercise 1", dataProviderClass = Exercise1Data.class)
  public void exercise1(Map<DataEnum, String[]> dataMap) {
    // 1.	Open test site by URL
    actionStep.openIndexPage();
    // 2. Assert Browser title
    assertionStep.assertTitleEquals("Home Page");
    // 3. Perform login
    actionStep.login(getProperty(USER_NAME), getProperty(PASSWORD));
    // 4. Assert Username is loggined
    assertionStep.assertThatUserNameDisplayed(getProperty(USER_NAME_TEXT));
    // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
    assertionStep.assertHeaderItemsDisplayed(dataMap.get(HEADERS));
    // 6. Assert that there are 4 images on the Index Page, and they are displayed
    assertionStep.assertImagesAreDisplayed(4);
    // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
    assertionStep.assertTextUnderIcons(dataMap.get(IMAGES_TEXTS));
    /* 8.	Assert that there is the iframe with “Frame Button” exist
       9.	Switch to the iframe and check that there is “Frame Button” in the iframe */
    assertionStep.assertFrameButtonIsInIframe();
    // 10.	Switch to original window back
    actionStep.switchToOriginalWindow();
    // 11.	Assert that there are 5 items in the Left Section are displayed and they have proper text
    assertionStep.assertLeftSectionItems(dataMap.get(LEFT_MENU));
  }

}
