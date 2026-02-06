package rizqydev;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import rizqydev.resolver.RandomParameterResolver;
import rizqydev.test.Calculator;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstractRandomCalculatorTest {
    protected final Calculator calculator = new Calculator();
}
