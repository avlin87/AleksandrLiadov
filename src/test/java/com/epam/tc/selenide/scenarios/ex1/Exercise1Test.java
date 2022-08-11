package com.epam.tc.selenide.scenarios.ex1;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.epam.tc.selenide.data.DataEnum.HEADERS;
import static com.epam.tc.selenide.data.DataEnum.IMAGES_TEXTS;
import static com.epam.tc.selenide.data.DataEnum.LEFT_MENU;
import static com.epam.tc.selenide.data.DataEnum.PASSWORD;
import static com.epam.tc.selenide.data.DataEnum.USER_NAME;
import static com.epam.tc.selenide.data.DataEnum.USER_NAME_TEXT;
import static com.epam.tc.selenide.utils.PropertiesLoaderTest.getProperty;

import com.codeborne.selenide.ElementsCollection;
import com.epam.tc.selenide.base.SelenideTestBase;
import com.epam.tc.selenide.data.DataEnum;
import com.epam.tc.selenide.data.exercises.Exercise1Data;
import com.epam.tc.selenide.pages.IndexPage;
import com.epam.tc.selenide.pages.components.HeaderMenu;
import com.epam.tc.selenide.pages.components.LeftMenu;
import com.epam.tc.selenide.pages.components.LoginComponent;
import java.util.Map;
import org.testng.annotations.Test;

public class Exercise1Test extends SelenideTestBase {

  @Test(dataProvider = "Exercise 1", dataProviderClass = Exercise1Data.class)
  public void exercise1(Map<DataEnum, String[]> dataMap) {
    IndexPage indexPage = page(IndexPage.class);//new IndexPage(webdriver());
    indexPage.openPage();

    LoginComponent loginComponent = indexPage.getLoginComponent();
    HeaderMenu headerMenu = indexPage.getHeaderMenu();
    LeftMenu leftMenu = indexPage.getLeftMenu();

    // 2. Assert Browser title
    indexPage.getTitle().shouldHave(attribute("text", "Home Page"));

    // 3. Perform login
    loginComponent.login(getProperty(USER_NAME), getProperty(PASSWORD));
    // 4. Assert Username is loggined
    assertUserLogged(loginComponent, getProperty(USER_NAME_TEXT));
    // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
    headerMenu.getHeaderElements()
        .shouldHave(size(dataMap.get(HEADERS).length))
        .shouldHave(textsInAnyOrder(dataMap.get(HEADERS)));
    // 6. Assert that there are 4 images on the Index Page, and they are displayed
    ElementsCollection pageImages = indexPage.getImages();
    assertFourElementsDisplayed(pageImages);
    //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
    assertAllElementsPresent(indexPage.getImagesTexts(), dataMap.get(IMAGES_TEXTS));
    //8.	Assert that there is the iframe with “Frame Button” exist
    indexPage.getIframes().shouldHave(sizeGreaterThan(0));
    //9.	Switch to the iframe and check that there is “Frame Button” in the iframe
    indexPage.isFrameButtonFoundInIframe().shouldBe(visible);
    //10.	Switch to original window back
    indexPage.switchToOriginalWindow();
    //11.	Assert that there are 5 items in the Left Section are displayed and they have proper text
    assertAllElementsPresent(leftMenu.getLeftElements(), dataMap.get(LEFT_MENU));
  }

  private void assertAllElementsPresent(ElementsCollection elements, String[] data) {
    elements.shouldHave(size(data.length))
        .shouldHave(textsInAnyOrder(data));
  }

  @SuppressWarnings("deprecation")
  private void assertFourElementsDisplayed(ElementsCollection elements) {
    elements.shouldHave(size(4))
        .forEach(selenideElement -> selenideElement.shouldBe(visible));
  }
}
