package com.epam.tc.hw4.pages.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HeaderMenu - Page Object for 'Header Menu'.
 *
 * @author Aleksandr Liadov
 */
public class HeaderMenu {

  @FindBy(css = "header ul[class='uui-navigation nav navbar-nav m-l8'] li a")
  private List<WebElement> headerElements;

  @FindBy(css = "header ul[class='uui-navigation nav navbar-nav m-l8'] li a.dropdown-toggle")
  private WebElement headerServiceDropDown;

  @FindBy(css = "header ul[class='uui-navigation nav navbar-nav m-l8'] li ul.dropdown-menu li a[href='different-elements.html']")
  private WebElement differentElementsItem;

  /**
   * Method returns List of texts of displayed headers.
   *
   * @return List<> - texts of displayed headers
   */
  public List<String> getDisplayedHeaders() {
    return headerElements.stream()
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  public void navigateToDifferentElementsPage() {
    headerServiceDropDown.click();
    differentElementsItem.click();
  }
}