package com.epam.tc.hw3.data;

public enum DataEnum {

  USER_NAME("userName"),
  PASSWORD("password"),
  USER_NAME_TEXT("userNameText"),

  INDEX_PAGE_URL,
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
