package com.epam.tc.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw6.entities.MetalsColorsInfo;

/**
 * LoginForm - form with Metals and Colors fields.
 *
 * @author Aleksandr Liadov
 */
public class MetalsColorsForm extends Form<MetalsColorsInfo> {

  @UI("#summary-block section div.info-panel-section p.radio input")
  public RadioButtons summary;

  @UI("#elements-block section div.info-panel-section p.checkbox input")
  public Checklist elements;

  @JDropdown(root = "#colors", list = "li", value = "span.text", expand = "span.caret")
  public Dropdown colors;

  @JDropdown(root = "#metals", list = "li", value = "span.text", expand = "span.caret")
  public Dropdown metals;

  @UI("#salad-dropdown .caret")
  public Button vegetablesListToggle;

  @UI("#salad-dropdown input")
  public Checklist vegetables;

  @UI("div.main-content form.form button#submit-button")
  public Button submit;
}
