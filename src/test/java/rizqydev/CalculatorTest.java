package rizqydev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import rizqydev.test.Calculator;
import rizqydev.test.generator.SimpleDisplayNameGenerator;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @Test
  // @DisplayName("Test addition of two integers")
  public void testAdd() {
    Integer result = calculator.add(2, 3);
    // assert result.equals(5) : "Expected 5 but got " + result;
    assertEquals(5, result);
  }

  // @Test
  // public void testAddFailure() {
  //   Integer result = calculator.add(2, 2);
  //   assertEquals(5, result);
  // }
  
  @Test
  public void testDivide() {
    Integer result = calculator.divide(10, 2);
    assertEquals(5, result);
  }

  @Test
  // @DisplayName("Test division by zero should throw IllegalArgumentException")
  public void testDivideByZero() {
    assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
  }

  @Test
  @Disabled
  public void testComingSoon() {
    // This test is coming soon
  }
}
