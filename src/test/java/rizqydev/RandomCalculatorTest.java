package rizqydev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import rizqydev.resolver.RandomParameterResolver;
import rizqydev.test.Calculator;

import java.util.Random;

public class RandomCalculatorTest extends AbstractRandomCalculatorTest {
    @Test
    void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testRandom2(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.divide(a, b);
        var expected = a / b;

        Assertions.assertEquals(result, expected);
    }
}
