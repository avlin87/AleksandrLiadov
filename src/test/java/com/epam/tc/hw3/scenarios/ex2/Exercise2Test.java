package com.epam.tc.hw3.scenarios.ex2;

import static com.epam.tc.hw3.data.DataEnum.LOG_PATTERNS;

import com.epam.tc.hw3.data.DataEnum;
import com.epam.tc.hw3.data.Exercise2Data;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.components.LogComponent;
import com.epam.tc.hw3.scenarios.BaseTest;
import java.util.Map;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

  @Test(dataProvider = "Exercise 2", dataProviderClass = Exercise2Data.class)
  public void exercise2(Map<DataEnum, String[]> dataMap) {
    DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
    LogComponent logComponent = differentElementsPage.getLogComponent();

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
