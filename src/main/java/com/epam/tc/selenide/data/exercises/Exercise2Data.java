package com.epam.tc.selenide.data.exercises;

import static com.epam.tc.selenide.data.DataEnum.LOG_PATTERNS;
import static com.epam.tc.selenide.data.components.LogComponentData.getLogComponentData;

import com.epam.tc.selenide.data.DataEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class Exercise2Data {

  @DataProvider(name = "Exercise 2")
  public static Iterator<Object[]> getData() {
    Collection<Object[]> data = new ArrayList<>();

    int limit = getLogComponentData().length;

    for (int i = 0; i < limit; i++) {
      Map<DataEnum, String[]> dataMap = new HashMap<>();
      data.add(new Object[]{dataMap});
      String[] logComponentData = getStringsData(getLogComponentData()[i]);
      dataMap.put(LOG_PATTERNS, logComponentData);
    }

    return data.iterator();
  }

  private static String[] getStringsData(Object[] elements) {
    return Arrays.stream(elements)
        .map(String::valueOf)
        .toArray(String[]::new);
  }
}
