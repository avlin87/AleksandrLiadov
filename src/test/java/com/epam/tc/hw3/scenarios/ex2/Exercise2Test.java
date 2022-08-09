package com.epam.tc.hw3.scenarios.ex2;

import static com.epam.tc.hw3.data.DataEnum.LOG_PATTERNS;
import static com.epam.tc.hw3.data.DataEnum.PASSWORD;
import static com.epam.tc.hw3.data.DataEnum.USER_NAME;
import static com.epam.tc.hw3.data.DataEnum.USER_NAME_TEXT;
import static com.epam.tc.hw3.utils.PropertiesLoaderTest.getProperty;

import com.epam.tc.hw3.data.DataEnum;
import com.epam.tc.hw3.data.Exercise2Data;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.IndexPage;
import com.epam.tc.hw3.pages.components.HeaderMenu;
import com.epam.tc.hw3.pages.components.LogComponent;
import com.epam.tc.hw3.pages.components.LoginComponent;
import com.epam.tc.hw3.scenarios.BaseTest;
import java.util.Map;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

  @Test(dataProvider = "Exercise 2", dataProviderClass = Exercise2Data.class)
  public void exercise2(Map<DataEnum, String[]> dataMap) {
    IndexPage indexPage = new IndexPage(webDriver);
    LoginComponent loginComponent = indexPage.getLoginComponent();
    HeaderMenu headerMenu = indexPage.getHeaderMenu();

    DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
    LogComponent logComponent = differentElementsPage.getLogComponent();

    // 1.	Open test site by URL
    indexPage.open();
    // 2. Assert Browser title
    softly.assertThat(indexPage.getTitle()).isEqualTo("Home Page");
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
    softly.assertThat(dataMap.get(LOG_PATTERNS)).allMatch(logComponent::isMatchFoundInLog);

    //check result
    softly.assertAll();
  }
}
