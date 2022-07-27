package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

import com.epam.tc.hw1.data.DivisionDataProvider;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.testng.annotations.Test;

public class CalculatorDivisionTest extends AbstractCalculatorTest {

  @Test(dataProvider = "divisionByZeroLongTestData", dataProviderClass = DivisionDataProvider.class)
  public void divisionByZeroLongTrowExceptionTest(long dividend, long divider) {
    Class<NumberFormatException> expectedException = NumberFormatException.class;
    String expectedMessage = "Attempt to divide by zero";

    ThrowingCallable callable = () -> calculator.div(dividend, divider);

    assertThatThrownBy(callable)
        .isInstanceOf(expectedException)
        .hasMessage(expectedMessage);
  }

  @Test(dataProvider = "divisionByZeroDoubleTestData", dataProviderClass = DivisionDataProvider.class)
  public void divisionByZeroReturnInfinityDoubleTest(double dividend, double divider, double expectedResult) {
    double div = calculator.div(dividend, divider);

    assertThat(div).as("infinity expected for double")
        .isEqualTo(expectedResult);
  }

  @Test
  public void divisionZeroByZeroReturnNaNDoubleTest() {
    double dividend = 0.0;
    double divider = 0.0;

    double div = calculator.div(dividend, divider);

    assertThat(div).as("NaN expected in case 0 divided by 0 for double values")
        .isNaN();
  }

  @Test(dataProvider = "divisionLongTestData", dataProviderClass = DivisionDataProvider.class)
  public void divisionLongTest(long dividend, long divider, long expectedResult) {
    long div = calculator.div(dividend, divider);

    assertThat(div).as("division of long values is incorrect")
        .isEqualTo(expectedResult);
  }

  @Test(dataProvider = "divisionDoubleTestData", dataProviderClass = DivisionDataProvider.class)
  public void divisionDoubleTest(double dividend, double divider, double expectedResult) {
    double calcAccuracy = 0.01;

    double div = calculator.div(dividend, divider);

    assertThat(div).as("division of double values is incorrect")
        .isCloseTo(expectedResult, within(calcAccuracy));
  }

}
