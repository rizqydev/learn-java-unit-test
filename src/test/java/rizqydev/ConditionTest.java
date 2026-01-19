package rizqydev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {
    @Test
    void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testOnlyOnWindows() {
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisableOnWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testEnableOnJava8() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testDisableOnJava8() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_21)
    void testEnabledOnJava11to21() {
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnabledOnJavaVendorOracle() {
    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testDisabledOnJavaVendorOracle() {
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledEnvironmentVariable() {
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testDisabledEnvironmentVariable() {
    }
}
