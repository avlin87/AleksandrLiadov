package com.epam.tc.hw6.utils;

import com.epam.tc.hw6.entities.MetalsColorsInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * JsonFileReader - class to read map of MetalsColorsInfo objects from Json file.
 *
 * @author Aleksandr Liadov
 */
@Slf4j
public class JsonFileReader {

  /**
   * Method for reading test data of MetalsColorsInfo objects from target Json file.
   *
   * @param jsonFileLocation - target Json file
   * @return - return map of MetalsColorsInfo objects
   */
  public static Map<String, MetalsColorsInfo> readJsonFile(String jsonFileLocation) {
    Map<String, MetalsColorsInfo> map = Collections.emptyMap();
    try {
      StringBuilder jsonFile = new StringBuilder();
      Files.readAllLines(Paths.get(jsonFileLocation)).forEach(jsonFile::append);
      map = new Gson()
          .fromJson(jsonFile.toString(), new TypeToken<HashMap<String, MetalsColorsInfo>>() {
          }.getType());
    } catch (IOException e) {
      log.error("Read MetalsColorsInfo from Json file failed :", e);
    }
    return map;
  }
}
