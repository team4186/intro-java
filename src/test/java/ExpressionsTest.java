import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("02-Expressions")
class ExpressionsTest {

    @Test
    @Order(1)
    @DisplayName("Create an expression that returns an integer 5")
    void giveMe5() {
        Expressions expressions = new Expressions();
        assertEquals(expressions.giveMe5(), 5);
    }

    @Test
    @Order(2)
    @DisplayName("Create an expression that returns a text 5")
    void giveMeFive() {
        Expressions expressions = new Expressions();

        HashSet<String> valids = new HashSet<>(Arrays.asList(
                "Five",
                "five",
                "5"
        ));

        assertTrue(valids.contains(expressions.giveMeFive()));
    }

    @Test
    @Order(3)
    @DisplayName("Create an expression that returns true")
    void tellTheTrue() {
        Expressions expressions = new Expressions();
        assertTrue(expressions.tellTheTrue());
    }
}