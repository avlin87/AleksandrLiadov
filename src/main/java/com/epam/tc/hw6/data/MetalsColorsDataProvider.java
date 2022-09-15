package com.epam.tc.hw6.data;

import com.epam.tc.hw6.entities.MetalsColorsInfo;
import com.epam.tc.hw6.utils.JsonFileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.testng.annotations.DataProvider;

/**
 * MetalsColorsDataProvider - data provider class.
 *
 * @author Aleksandr Liadov
 */
public class MetalsColorsDataProvider {

  /**
   * Method request test data from json file.
   *
   * @return - iterator of test data collection
   */
  @DataProvider(name = "Metals Colors From Json")
  public static Iterator<Object[]> getData() {
    Collection<Object[]> data = new ArrayList<>();
    Map<String, MetalsColorsInfo> map =
        JsonFileReader.readJsonFile("src/main/resources/JDI_ex8_metalsColorsDataSet.json");
    map.values().forEach(x -> data.add(new Object[]{x}));

    return data.iterator();
  }
}
