package com.epam.tc.selenide.scenarios.ex2;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.epam.tc.selenide.data.DataEnum.LOG_PATTERNS;
import static com.epam.tc.selenide.data.DataEnum.PASSWORD;
import static com.epam.tc.selenide.data.DataEnum.USER_NAME;
import static com.epam.tc.selenide.data.DataEnum.USER_NAME_TEXT;
import static com.epam.tc.selenide.utils.PropertiesLoaderTest.getProperty;

import com.epam.tc.selenide.base.SelenideTestBase;
import com.epam.tc.selenide.data.DataEnum;
import com.epam.tc.selenide.data.exercises.Exercise2Data;
import com.epam.tc.selenide.pages.DifferentElementsPage;
import com.epam.tc.selenide.pages.IndexPage;
import com.epam.tc.selenide.pages.components.HeaderMenu;
import com.epam.tc.selenide.pages.components.LogComponent;
import com.epam.tc.selenide.pages.components.LoginComponent;
import java.util.Arrays;
import java.util.Map;
import org.testng.annotations.Test;

public class Exercise2Test extends SelenideTestBase {

  @Test(dataProvider = "Exercise 2", dataProviderClass = Exercise2Data.class)
  public void exercise2(Map<DataEnum, String[]> dataMap) {
    IndexPage indexPage = page(IndexPage.class);
    indexPage.openPage();

    LoginComponent loginComponent = indexPage.getLoginComponent();
    HeaderMenu headerMenu = indexPage.getHeaderMenu();

    DifferentElementsPage differentElementsPage = page(DifferentElementsPage.class);
    LogComponent logComponent = differentElementsPage.getLogComponent();

    // 2. Assert Browser title
    indexPage.getTitle().shouldHave(attribute("text", "Home Page"));
    // 3. Perform login
    loginComponent.login(getProperty(USER_NAME), getProperty(PASSWORD));
    // 4. Assert Username is loggined
    assertUserLogged(loginComponent, getProperty(USER_NAME_TEXT));
    // 5. Open through the header menu Service -> Different Elements Page
    headerMenu.navigateToDifferentElementsPage();
    // 6.	Select checkboxes
    differentElementsPage.selectCheckboxes();
    // 7.	Select radio
    differentElementsPage.selectRadioButton();
    // 8.	Select in dropdown
    differentElementsPage.selectInDropDown();
    // 9.	Assert that
    // •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    // •	for radio button there is a log row and value is corresponded to the status of radio button
    // •	for dropdown there is a log row and value is corresponded to the selected value.
    Arrays.stream(dataMap.get(LOG_PATTERNS))
        .forEach(patter -> logComponent.isMatchFoundInLog(patter).shouldBe(visible));
  }
}
