package com.epam.tc.hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.tc.hw6.entities.User;
import com.epam.tc.hw6.pages.HomePage;
import com.epam.tc.hw6.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    public static HomePage homePage;

    public static MetalsColorsPage metalsColorsPage;

    public static void open() {
        homePage.open();
    }

    public static void login(User user) {
        homePage.login(user);
    }

    public static void checkUserLoggedIn(User user) {
        homePage.checkUserLoggedIn(user);
    }

    public static void navigateToMetalsColorsPage() {
        homePage.navigateToMetalsColorsPage();
    }

    public static void fillFormMetalsColors() {
        metalsColorsPage.fillFormMetalsColors();
    }

    public static void submitFormMetalsColors() {
        metalsColorsPage.submitForm();
    }

    public static void checkResultSection() {
        metalsColorsPage.checkResultSection();
    }
}