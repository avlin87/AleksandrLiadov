package com.epam.tc.hw5.steps;

import static com.epam.tc.hw5.utils.PropertiesLoaderTest.getProperty;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.dataproviders.DataEnum;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

/**
 * Given definitions class.
 *
 * @author Aleksandr Liadov
 */
public class GivenStepDef extends AbstractBaseStepDef {

  @Given("I open JDI GitHub site")
  public void openJdiGitHubSite() {
    indexPage.open();
  }

  @And("I login as user {string}")
  public void loginAsUser(String userName) {
    loginComponent.login(getProperty(DataEnum.USER_NAME), getProperty(DataEnum.PASSWORD));
    assertThat(loginComponent.getUserNameText()).isEqualToIgnoringCase(userName);
  }

}
