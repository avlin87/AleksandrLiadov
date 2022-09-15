package com.epam.tc.hw6.entities;

import com.jdiai.tools.DataClass;

/**
 * User - dataclass for user credentials.
 */
public class User extends DataClass<User> {

  public String name;
  public String password;
  public String fullName;

  public String getFullName() {
    return fullName;
  }
}
