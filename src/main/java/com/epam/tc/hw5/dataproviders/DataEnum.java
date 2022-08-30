package com.epam.tc.hw5.dataproviders;

/**
 * DataEnum - class for unification of used data.
 *
 * @author Aleksandr Liadov
 */
public enum DataEnum {

  USER_NAME("userName"),
  PASSWORD("password");

  private final String value;

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
