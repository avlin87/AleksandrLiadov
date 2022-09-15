package com.epam.tc.hw6.data;

import com.epam.tc.hw6.entities.User;

/**
 * JdiTestData - Test data class.
 *
 * @author Aleksandr Liadov
 */
public class JdiTestData {

  public static final User ROMAN = new User().set(c -> {
    c.name = "Roman";
    c.password = "Jdi1234";
    c.fullName = "ROMAN IOVLEV";
  });

}
