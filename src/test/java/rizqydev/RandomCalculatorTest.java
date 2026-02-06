package rizqydev;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
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

    @DisplayName("Test with parameter")
    @ParameterizedTest(name = "{displayName} dengan paramater {0}")
    @ValueSource(ints = {1, 2})
    void testWithParameter(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 2, 3);
    }

    @DisplayName("Test with parameter source")
    @ParameterizedTest(name = "{displayName} dengan paramater {0}")
    @MethodSource("parameterSource")
    void testWithMethodSource(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }
}
