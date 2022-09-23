package com.epam.tc.hw3.data;

import static com.epam.tc.hw3.data.DataEnum.HEADERS;
import static com.epam.tc.hw3.data.DataEnum.IMAGES_TEXTS;
import static com.epam.tc.hw3.data.DataEnum.INDEX_PAGE_URL;
import static com.epam.tc.hw3.data.DataEnum.LEFT_MENU;

import com.epam.tc.hw3.data.components.HeaderMenuData;
import com.epam.tc.hw3.data.components.LeftMenuData;
import com.epam.tc.hw3.data.pages.IndexPageData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class Exercise1Data {

  @DataProvider(name = "Exercise 1")
  public static Iterator<Object[]> getData() {
    Collection<Object[]> data = new ArrayList<>();

    int limit = Math.min(HeaderMenuData.getHeaderData().length,
        Math.min(IndexPageData.getImagesTexts().length, LeftMenuData.getLeftMenuData().length));

    for (int i = 0; i < limit; i++) {
      Map<DataEnum, String[]> dataMap = new HashMap<>();
      data.add(new Object[]{dataMap});

      dataMap.put(INDEX_PAGE_URL, new String[]{"https://jdi-testing.github.io/jdi-light/index.html"});

      String[] headersData = getStringsData(HeaderMenuData.getHeaderData()[i]);
      dataMap.put(HEADERS, headersData);

      String[] imagesTexts = getStringsData(IndexPageData.getImagesTexts()[i]);
      dataMap.put(IMAGES_TEXTS, imagesTexts);

      String[] leftMenuData = getStringsData(LeftMenuData.getLeftMenuData()[i]);
      dataMap.put(LEFT_MENU, leftMenuData);
    }

    return data.iterator();
  }

  private static String[] getStringsData(Object[] elements) {
    return Arrays.stream(elements)
        .map(String::valueOf)
        .toArray(String[]::new);
  }
}
