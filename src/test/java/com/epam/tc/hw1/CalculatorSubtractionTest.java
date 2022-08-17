package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.data.SubtractionDataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtractionTest extends AbstractCalculatorTest {

  @Test(dataProvider = "subtractionLongTestData", dataProviderClass = SubtractionDataProvider.class)
  public void subtractionLongTest(long reduce, long subtract, long expectedResult) {
    long sub = calculator.sub(reduce, subtract);

    assertThat(sub).isEqualTo(expectedResult);
  }

  @Test(dataProvider = "subtractionDoubleTestData", dataProviderClass = SubtractionDataProvider.class)
  public void subtractionDoubleTest(double reduce, double subtract, double expectedResult) {
    double sub = calculator.sub(reduce, subtract);

    assertThat(sub).isEqualTo(expectedResult);
  }

}
