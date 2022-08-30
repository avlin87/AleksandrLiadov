package com.epam.tc.hw5.pages;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

/**
 * IndexPage - Page Object for 'Index Page'.
 *
 * @author Aleksandr Liadov
 */
@RequiredArgsConstructor
public class IndexPage {

  private final WebDriver webDriver;

  public void open() {
    webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
  }

}