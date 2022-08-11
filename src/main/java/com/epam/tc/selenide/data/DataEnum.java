package com.epam.tc.selenide.data;

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

  DataEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
