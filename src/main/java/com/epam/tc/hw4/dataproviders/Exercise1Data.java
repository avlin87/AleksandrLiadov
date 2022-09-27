package com.epam.tc.hw4.dataproviders;

import static com.epam.tc.hw4.dataproviders.DataEnum.HEADERS;
import static com.epam.tc.hw4.dataproviders.DataEnum.IMAGES_TEXTS;
import static com.epam.tc.hw4.dataproviders.DataEnum.LEFT_MENU;
import static com.epam.tc.hw4.dataproviders.components.HeaderMenuData.getHeaderData;
import static com.epam.tc.hw4.dataproviders.components.LeftMenuData.getLeftMenuData;
import static com.epam.tc.hw4.dataproviders.pages.IndexPageData.getImagesTexts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.testng.annotations.DataProvider;

/**
 * Exercise1Data - class prepares test data to be provided for Exercise 1.
 *
 * @author Aleksandr Liadov
 */
public class Exercise1Data {

  /**
   * Method combines data of Page Objects: HeaderMenuData, IndexPageData, LeftMenuData.
   *
   * @return Iterator<> - result data provider
   */
  @DataProvider(name = "Exercise 1")
  public static Iterator<Object[]> getData() {
    Collection<Object[]> data = new ArrayList<>();

    int limit = Math.min(getHeaderData().length,
        Math.min(getImagesTexts().length, getLeftMenuData().length));

    for (int i = 0; i < limit; i++) {
      Map<DataEnum, String[]> dataMap = new HashMap<>();
      data.add(new Object[]{dataMap});

      String[] headersData = getStringsData(getHeaderData()[i]);
      dataMap.put(HEADERS, headersData);

      String[] imagesTexts = getStringsData(getImagesTexts()[i]);
      dataMap.put(IMAGES_TEXTS, imagesTexts);

      String[] leftMenuData = getStringsData(getLeftMenuData()[i]);
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
