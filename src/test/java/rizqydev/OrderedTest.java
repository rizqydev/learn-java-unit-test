package rizqydev;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {
    private int counter = 0;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @Test
    @Order(1)
    void test3() {
        counter++;

        System.out.println("counter = " + counter);
    }

    @Test
    @Order(2)
    void test2() {
        counter++;

        System.out.println("counter = " + counter);
    }

    @Test
    @Order(3)
    void test1() {
        counter++;

        System.out.println("counter = " + counter);
    }

    @Test
    @Order(4)
    void test5() {
        counter++;

        System.out.println("counter = " + counter);
    }
}
