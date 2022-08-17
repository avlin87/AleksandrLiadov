package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import com.epam.tc.hw1.data.MultiplicationDataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplicationTest extends AbstractCalculatorTest {

  @Test(dataProvider = "multLongTestData", dataProviderClass = MultiplicationDataProvider.class)
  public void multLongTest(long a, long b, long expectedResult) {
    long mult = calculator.mult(a, b);

    assertThat(mult).isEqualTo(expectedResult);
  }

  @Test(dataProvider = "multDoubleTestData", dataProviderClass = MultiplicationDataProvider.class)
  public void multDoubleTest(double a, double b, double expectedResult) {
    double mult = calculator.mult(a, b);

    assertThat(mult).isEqualTo(expectedResult, offset(0.9));
  }
}
