package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.driver.WebDriverSingleton;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.WebElement;

/**
 * Then definitions class.
 *
 * @author Aleksandr Liadov
 */
public class ThenStepDef extends AbstractBaseStepDef {

  /**
   * Method check that page with correct title is opened.
   *
   * @param titleName - String title.
   */
  @Then("{string} page should be opened")
  public void pageShouldBeOpened(String titleName) {
    assertThat(WebDriverSingleton.getWebDriver().getTitle())
        .as("Check Title has correct name")
        .isEqualTo(titleName);
  }

  /**
   * Method check that log contains correct amount of displayed rows.
   *
   * @param logRowsNumber -int expected number of log rows.
   */
  @Then("Log should contain {int} displayed rows")
  public void logShouldContainNumberOfDisplayedRows(int logRowsNumber) {
    assertThat(logComponent.getLogElements())
        .as("Check log component contains correct number of messages")
        .hasSize(logRowsNumber);
    assertThat(logComponent.getLogElements())
        .as("Check that log messages are displayed")
        .allMatch(WebElement::isDisplayed);
  }

  @And("Log should contain message that checkbox {string} status changed to {string}")
  public void checkLogMessageConditionChanged(String nameOfCheckbox, String expectedValue) {
    executeLogMessageCheck(nameOfCheckbox, ": condition changed to ", expectedValue);
  }

  @And("value of {string} field changed to {string}")
  public void checkLogMessageValueChanged(String nameOfFiled, String expectedValue) {
    executeLogMessageCheck(nameOfFiled, ": value changed to ", expectedValue);
  }

  /**
   * Method check that user table contains correct number of dropdowns in Type column.
   *
   * @param count - int expected number of dropdowns.
   */
  @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
  public void checkNumberOfDropdownsDisplayed(int count) {
    assertThat(userTablePage.getNumberOfDropdownsInTypeColumn())
        .as("Check number of dropdown fields in Type column")
        .isEqualTo(count);
  }

  /**
   * Method check that user table contains correct number of Usernames in User column.
   *
   * @param count - int expected number of Usernames.
   */
  @And("{int} Usernames should be displayed on Users Table on User Table Page")
  public void checkNumberOfUsernamesDisplayed(int count) {
    assertThat(userTablePage.getNumberOfUsernames())
        .as("Check number of User names displayed in User column")
        .isEqualTo(count);
  }

  /**
   * Method check that user table contains correct number of Descriptions in Description column.
   *
   * @param count - int expected number of Descriptions.
   */
  @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
  public void checkNumberOfDescriptionsDisplayed(int count) {
    assertThat(userTablePage.getNumberOfDescriptionTexts())
        .as("Check number of Descriptions displayed in Description column under image")
        .isEqualTo(count);
  }

  /**
   * Method check that user table contains correct number of checkboxes in Description column.
   *
   * @param count - int expected number of checkboxes.
   */
  @And("{int} checkboxes should be displayed on Users Table on User Table Page")
  public void checkNumberOfCheckboxesDisplayed(int count) {
    assertThat(userTablePage.getNumberOfCheckboxes())
        .as("Check number of checkboxes displayed in Description column under image")
        .isEqualTo(count);
  }

  /**
   * Method checks Table contains correct Heads names and populated according to DataTable.
   *
   * @param table - DataTable data provided in table format
   */
  @And("^User table should contain following values:$")
  public void checkUserTableValues(DataTable table) {
    List<Map<String, String>> rows = table.asMaps(String.class, String.class);
    if (!rows.isEmpty()) {
      checkTableHead(rows.get(0).keySet());
      checkTableValues(rows);
    }
  }

  /**
   * Method check content of drop list for Roman user in Type column.
   *
   * @param table - DataTable expected content of drop list
   */
  @And("droplist should contain values in column Type for user Roman")
  public void checkDropListForRoman(DataTable table) {
    List<String> expectedValues = getExpectedValues(table);
    List<String> actualValues = userTablePage.getDropListValuesForUser("Roman");

    assertThat(actualValues)
        .as("Check drop list values")
        .containsAll(expectedValues);
  }

  /**
   * Method check that one log message present with correct text.
   *
   * @param logMessage - String log message.
   */
  @Then("1 log row has {string} text in log section")
  public void checkOneCorrectLogMessageDisplayed(String logMessage) {
    String predicate = "^(\\d{2}.?){3}(?i)(" + logMessage + ")$";

    assertThat(logComponent.getLogTexts())
        .as("Check number of log messages")
        .hasSize(1);
    assertThat(logComponent.getLogTexts().get(0))
        .as("Check log message has expected text")
        .matches(predicate);
  }

  private void executeLogMessageCheck(String fieldName, String expectedText, String expectedValue) {
    String predicate = "^(\\d{2}.?){3}(?i)(" + fieldName + expectedText + expectedValue + ")$";
    assertThat(logComponent.getLogTexts())
        .as("Check log messages contain following predicate: '" + predicate + "'")
        .anyMatch(logText -> logText.matches(predicate));
  }

  private void checkTableHead(Set<String> keySet) {
    assertThat(userTablePage.getTableHeadTexts())
        .as("Check Head names of User table")
        .containsAll(keySet);
  }

  private void checkTableValues(List<Map<String, String>> rows) {
    for (Map<String, String> row : rows) {
      Map<String, String> rowData = userTablePage.getRowById(row.get("Number"));
      row.forEach((key, value) -> {
        assertThat(rowData)
            .as("Check that row contains cell for expected column")
            .containsKey(key);
        assertThat(value)
            .as("Check that value of '" + key + "' column is correct")
            .isEqualTo(rowData.get(key));
      });
    }
  }

  private List<String> getExpectedValues(DataTable table) {
    List<String> expectedValues = new ArrayList<>();
    table.asMaps(String.class, String.class)
        .forEach(x -> x.values()
            .stream()
            .findFirst()
            .ifPresent(expectedValues::add));
    return expectedValues;
  }
}
