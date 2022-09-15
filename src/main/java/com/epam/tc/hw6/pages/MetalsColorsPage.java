package com.epam.tc.hw6.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw6.entities.MetalsColorsInfo;
import com.epam.tc.hw6.forms.MetalsColorsForm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MetalsColorsPage - Page object for 'Metals Colors Page'.
 *
 * @author Aleksandr Liadov
 */
public class MetalsColorsPage extends WebPage {

  @UI("section[class='uui-info-panel-horizontal'] "
      + "div[class='info-panel-body info-panel-body-result'] div ul li")
  public WebList resultSection;

  public MetalsColorsForm metalsColorsForm;

  /**
   * Method populates Metals and Colors form.
   */
  public void fillFormMetalsColors(MetalsColorsInfo metalsColorsInfo) {
    if (metalsColorsInfo.summary != null && metalsColorsInfo.summary.length > 0) {
      metalsColorsForm.summary.select(metalsColorsInfo.summary);
      metalsColorsForm.summary.assertThat().enabled(metalsColorsInfo.summary);
    }

    if (metalsColorsInfo.elements != null && metalsColorsInfo.elements.length > 0) {
      metalsColorsForm.elements.select(metalsColorsInfo.elements);
      metalsColorsForm.elements.assertThat().checked(metalsColorsInfo.elements);
    }

    if (metalsColorsInfo.color != null) {
      metalsColorsForm.colors.select(metalsColorsInfo.color);
      metalsColorsForm.colors.assertThat().enabled(metalsColorsInfo.color);
    }

    if (metalsColorsInfo.metals != null) {
      metalsColorsForm.metals.select(metalsColorsInfo.metals);
      metalsColorsForm.metals.assertThat().enabled(metalsColorsInfo.metals);
    }

    if (metalsColorsInfo.vegetables != null && metalsColorsInfo.vegetables.length > 0) {
      openVegetablesDropDownListAndUnselectAll();
      metalsColorsForm.vegetables.select(metalsColorsInfo.vegetables);
      metalsColorsForm.vegetables.assertThat().checked(metalsColorsInfo.vegetables);
    }
  }

  /**
   * Method validate text in 'Result' section.
   */
  public void checkResultSection(MetalsColorsInfo metalsColorsInfo) {
    List<String> expectedResult = generateExpectedResult(metalsColorsInfo);
    resultSection.assertThat()
        .displayed()
        .values(expectedResult);
  }

  public void submitForm() {
    metalsColorsForm.submit();
  }

  private void openVegetablesDropDownListAndUnselectAll() {
    metalsColorsForm.vegetablesListToggle.click();
    metalsColorsForm.vegetables.checked().forEach(x -> metalsColorsForm.vegetables.select(x));
  }

  private List<String> generateExpectedResult(MetalsColorsInfo metalsColorsInfo) {
    List<String> expectedResult = new ArrayList<>();
    getSummaryText(metalsColorsInfo, expectedResult);
    getElementsText(metalsColorsInfo, expectedResult);
    getColorText(metalsColorsInfo, expectedResult);
    getMetalText(metalsColorsInfo, expectedResult);
    getVegetablesText(metalsColorsInfo, expectedResult);

    return expectedResult;
  }

  private void getSummaryText(MetalsColorsInfo metalsColorsInfo, List<String> expectedResult) {
    String summ = "Summary: ";
    if (metalsColorsInfo.summary != null) {
      if (metalsColorsInfo.summary.length == 2) {
        summ += Integer.parseInt(metalsColorsInfo.summary[0])
            + Integer.parseInt(metalsColorsInfo.summary[1]);
      } else if (metalsColorsInfo.summary.length == 1) {
        if (Integer.parseInt(metalsColorsInfo.summary[0]) % 2 == 0) {
          summ += Integer.parseInt(metalsColorsInfo.summary[0]) + 1;
        } else {
          summ += Integer.parseInt(metalsColorsInfo.summary[0]) + 2;
        }
      }
    } else {
      summ += "3";
    }
    expectedResult.add(summ);
  }

  private void getElementsText(MetalsColorsInfo metalsColorsInfo, List<String> expectedResult) {
    if (metalsColorsInfo.elements != null && metalsColorsInfo.elements.length > 0) {
      StringBuilder elements = new StringBuilder("Elements: ");
      Arrays.stream(metalsColorsInfo.elements).forEach(x -> {
        elements.append(x);
        elements.append(", ");
      });
      elements.delete(elements.length() - 2, elements.length());
      expectedResult.add(elements.toString());
    }
  }

  private void getColorText(MetalsColorsInfo metalsColorsInfo, List<String> expectedResult) {
    String color = "Color: ";
    if (metalsColorsInfo.color != null) {
      color += metalsColorsInfo.color;
    } else {
      color += "Colors";
    }
    expectedResult.add(color);
  }

  private void getMetalText(MetalsColorsInfo metalsColorsInfo, List<String> expectedResult) {
    String metal = "Metal: ";
    if (metalsColorsInfo.metals != null) {
      metal += metalsColorsInfo.metals;
    } else {
      metal += "Metals";
    }
    expectedResult.add(metal);
  }

  private void getVegetablesText(MetalsColorsInfo metalsColorsInfo, List<String> expectedResult) {
    StringBuilder vegetables = new StringBuilder("Vegetables: ");
    if (metalsColorsInfo.vegetables == null || metalsColorsInfo.vegetables.length == 0) {
      vegetables.append("Vegetables");
    } else {
      Arrays.stream(metalsColorsInfo.vegetables).forEach(x -> {
        vegetables.append(x);
        vegetables.append(", ");
      });
      vegetables.delete(vegetables.length() - 2, vegetables.length());
      expectedResult.add(vegetables.toString());
    }
  }
}
