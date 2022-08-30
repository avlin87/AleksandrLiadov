package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * UserTablePage - Page Object for 'User Table Page'.
 *
 * @author Aleksandr Liadov
 */
public class UserTablePage {

  @FindBy(css = "#user-table tbody tr td select")
  private List<WebElement> dropdownsInTypeColumn;

  @FindBy(css = "#user-table tbody tr td a[href]")
  private List<WebElement> userNames;

  @FindBy(css = "#user-table tbody tr td div.user-descr span")
  private List<WebElement> descriptionTexts;

  @FindBy(css = "#user-table tbody tr td div.user-descr input[type='checkbox']")
  private List<WebElement> checkboxes;

  @FindBy(css = "#user-table thead tr th")
  private List<WebElement> tableHeads;

  @FindBy(css = "#user-table tbody tr")
  private List<WebElement> uerTableRows;

  public int getNumberOfDropdownsInTypeColumn() {
    return getDisplayedCount(dropdownsInTypeColumn);
  }

  public int getNumberOfUsernames() {
    return getDisplayedCount(userNames);
  }

  public int getNumberOfDescriptionTexts() {
    return getDisplayedCount(descriptionTexts);
  }

  public int getNumberOfCheckboxes() {
    return getDisplayedCount(checkboxes);
  }

  /**
   * Method returns collection of User Table Heads names.
   *
   * @return List - User Table Heads names
   */
  public List<String> getTableHeadTexts() {
    return tableHeads.stream()
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  /**
   * Method returns values of drop list from Type column by specified userName.
   *
   * @param userName - String specified userName.
   * @return - List - drop list values.
   */
  public List<String> getDropListValuesForUser(String userName) {
    List<String> dropListValues = new ArrayList<>();
    findRow(By.cssSelector("td a[href]"), userName)
        .ifPresent(webElement ->
            webElement.findElements(By.cssSelector("td select option"))
                .stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .forEach(dropListValues::add));
    return dropListValues;
  }

  /**
   * Method return map of values for row with specified number.
   *
   * @param number - value of Number column of User Table.
   * @return - Map of columns names and cell values.
   */
  public Map<String, String> getRowById(String number) {
    Map<String, String> rowMap = new HashMap<>();
    findRow(By.cssSelector("td:nth-child(1)"), number)
        .ifPresent(webElement -> populateMap(number, rowMap, webElement));
    return rowMap;
  }

  /**
   * Method clicks on checkbox in description column for provided userName.
   *
   * @param checkboxName - String name of checkbox
   * @param userName     - String user name
   */
  public void selectVipCheckboxFor(String checkboxName, String userName) {
    findRow(By.cssSelector("td a[href]"), userName)
        .ifPresent(foundRow -> {
          String checkboxLabel =
              foundRow.findElement(By.cssSelector("td div.user-descr label[for]")).getText();
          if (checkboxLabel.equalsIgnoreCase(checkboxName)) {
            foundRow.findElement(By.cssSelector("td div.user-descr input[type=checkbox]"))
                .click();
          }
        });
  }

  private int getDisplayedCount(List<WebElement> dropdownsInTypeColumn) {
    return (int) dropdownsInTypeColumn.stream()
        .filter(WebElement::isDisplayed)
        .count();
  }

  private Optional<WebElement> findRow(By by, String value) {
    return uerTableRows.stream()
        .filter(webElement -> webElement.findElement(by).getText().equals(value)
            && webElement.isDisplayed())
        .findFirst();
  }

  private void populateMap(String number, Map<String, String> rowMap, WebElement row) {
    rowMap.put("Number", number);
    rowMap.put("User", row.findElement(By.cssSelector("td a")).getText());
    rowMap.put("Description",
        row.findElement(By.cssSelector("td div.user-descr span")).getText().replace("\n", " "));
  }
}