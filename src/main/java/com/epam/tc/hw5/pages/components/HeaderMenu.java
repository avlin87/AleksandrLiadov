package com.epam.tc.hw5.pages.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
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

  /**
   * Method find page element by itemName. Click if item found.
   *
   * @param itemName - String item name.
   */
  public void navigateToPage(String itemName) {
    Optional<WebElement> headerItem = headerElements.stream()
        .filter(webElement -> webElement.getText().matches("^(?i)" + itemName + "$"))
        .findFirst();

    assertThat(headerItem.isPresent())
        .describedAs("Element '" + itemName + "' not found")
        .isTrue();

    headerItem.get().click();
  }
}