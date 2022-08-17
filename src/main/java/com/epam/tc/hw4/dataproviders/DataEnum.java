package com.epam.tc.hw4.dataproviders;

/**
 * DataEnum - class for unification of used data.
 *
 * @author Aleksandr Liadov
 */
public enum DataEnum {

  USER_NAME("userName"),
  PASSWORD("password"),
  USER_NAME_TEXT("userNameText"),

  HEADERS,
  IMAGES_TEXTS,
  LEFT_MENU,
  LOG_PATTERNS;

  private String value;

  DataEnum() {
  }

  DataEnum(final String value) {
    this.value = value;
  }

  /**
   * Method returns value of DataEnum.
   *
   * @return String - value is present for user-data only
   */
  public String getValue() {
    return value;
  }
}
