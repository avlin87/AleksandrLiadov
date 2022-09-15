package com.epam.tc.hw6.data;

import com.epam.tc.hw6.entities.MetalsColorsInfo;
import com.epam.tc.hw6.entities.User;

public class JdiTestData {
    public static final User ROMAN = new User().set(c -> {
        c.name = "Roman";
        c.password = "Jdi1234";
        c.fullName = "ROMAN IOVLEV";
    });

    public static final MetalsColorsInfo METALS_COLORS_INFO = new MetalsColorsInfo().set(c -> {
        c.summary = new String[]{"3", "8"};
        c.elements = new String[]{"Water", "Fire"};
        c.colors = "Red";
        c.metals = "Selen";
        c.vegetables = new String[]{"Cucumber", "Tomato"};
    });

    public static final String[] EXPECTED_RESULTS = new String[]{
            "Summary: 11",
            "Elements: Water, Fire",
            "Color: Red",
            "Metal: Selen",
            "Vegetables: Cucumber, Tomato"
    };
}
