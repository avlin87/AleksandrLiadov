package com.epam.tc.hw4.tests.ex2;

import static com.epam.tc.hw4.dataproviders.DataEnum.LOG_PATTERNS;
import static com.epam.tc.hw4.dataproviders.DataEnum.PASSWORD;
import static com.epam.tc.hw4.dataproviders.DataEnum.USER_NAME;
import static com.epam.tc.hw4.dataproviders.DataEnum.USER_NAME_TEXT;
import static com.epam.tc.hw4.utils.PropertiesLoaderTest.getProperty;

import com.epam.tc.hw4.dataproviders.DataEnum;
import com.epam.tc.hw4.dataproviders.Exercise2Data;
import com.epam.tc.hw4.listners.AllureListener;
import com.epam.tc.hw4.tests.AbstractBaseSeleniumTest;
import io.qameta.allure.Story;
import java.util.Map;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Story("Different Elements page")
@Listeners({AllureListener.class})
public class Exercise2Test extends AbstractBaseSeleniumTest {

  @Test(description = "Test Different Elements Page content",
      dataProvider = "Exercise 2", dataProviderClass = Exercise2Data.class)
  public void exercise2(Map<DataEnum, String[]> dataMap) {
    // 1.	Open test site by URL
    actionStep.openIndexPage();
    // 2. Assert Browser title
    assertionStep.assertTitleEquals("Home Page");
    // 3. Perform login
    actionStep.login(getProperty(USER_NAME), getProperty(PASSWORD));
    // 4. Assert Username is loggined
    assertionStep.assertThatUserNameDisplayed(getProperty(USER_NAME_TEXT));
    // 5. Open through the header menu Service -> Different Elements Page
    actionStep.navigateToDifferentElementsPage();
    // 6.	Select checkboxes
    actionStep.selectCheckboxes();
    // 7.	Select radio
    actionStep.selectRadioButton();
    // 8.	Select in dropdown
    actionStep.selectInDropDown();
    // 9.	Assert that
    // •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    // •	for radio button there is a log row and value is corresponded to the status of radio button
    // •	for dropdown there is a log row and value is corresponded to the selected value.
    assertionStep.assertLogMessages(dataMap.get(LOG_PATTERNS));
  }
}
