package com.epam.tc.hw6.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw6.forms.MetalsColorsForm;

import static com.epam.tc.hw6.data.JdiTestData.EXPECTED_RESULTS;
import static com.epam.tc.hw6.data.JdiTestData.METALS_COLORS_INFO;

public class MetalsColorsPage extends WebPage {

    @UI("section[class='uui-info-panel-horizontal'] div[class='info-panel-body info-panel-body-result'] div ul li")
    public WebList resultWidget;

    public MetalsColorsForm metalsColorsForm;

    public void fillFormMetalsColors() {
        metalsColorsForm.summary.select(METALS_COLORS_INFO.summary);
        metalsColorsForm.summary.assertThat().enabled(METALS_COLORS_INFO.summary);

        metalsColorsForm.elements.select(METALS_COLORS_INFO.elements);
        metalsColorsForm.elements.assertThat().checked(METALS_COLORS_INFO.elements);

        metalsColorsForm.colors.select(METALS_COLORS_INFO.colors);
        metalsColorsForm.colors.assertThat().enabled(METALS_COLORS_INFO.colors);

        metalsColorsForm.metals.select(METALS_COLORS_INFO.metals);
        metalsColorsForm.metals.assertThat().enabled(METALS_COLORS_INFO.metals);

        openVegetablesDropDownListAndUnselectAll();
        metalsColorsForm.vegetables.select(METALS_COLORS_INFO.vegetables);
        metalsColorsForm.vegetables.assertThat().checked(METALS_COLORS_INFO.vegetables);
    }

    public void submitForm() {
        metalsColorsForm.submit();
    }

    public void checkResultSection() {
        resultWidget.assertThat()
                .displayed()
                .size(5)
                .values(EXPECTED_RESULTS);
    }

    private void openVegetablesDropDownListAndUnselectAll() {
        metalsColorsForm.vegetablesListToggle.click();
        metalsColorsForm.vegetables.checked().forEach(x -> metalsColorsForm.vegetables.select(x));
    }
}
