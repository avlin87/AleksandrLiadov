package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.data.SumDataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractCalculatorTest {

  @Test(dataProvider = "sumLongTestData", dataProviderClass = SumDataProvider.class)
  public void sumLongTest(long a, long b, long expectedResult) {
    long sum = calculator.sum(a, b);

    assertThat(sum).isEqualTo(expectedResult);
  }

  @Test(dataProvider = "sumDoubleTestData", dataProviderClass = SumDataProvider.class)
  public void sumDoubleTest(double a, double b, double expectedResult) {
    double sum = calculator.sum(a, b);

    assertThat(sum).isEqualTo(expectedResult);
  }
}