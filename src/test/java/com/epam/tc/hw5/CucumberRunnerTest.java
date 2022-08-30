package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
    plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}