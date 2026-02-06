package rizqydev;

import org.junit.jupiter.api.*;

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

    @RepeatedTest(value = 10
            , name = "{displayName}"
    )
    void testRandomRepeat(Random random, TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " of " + repetitionInfo.getCurrentRepetition() + " from " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.divide(a, b);
        var expected = a / b;

        System.out.println("result " + result);

        Assertions.assertEquals(result, expected);
    }
}
