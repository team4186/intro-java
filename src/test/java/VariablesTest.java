import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("01-Variables")
class VariablesTest {

    @Test
    @Order(1)
    @DisplayName("Variables can be reassigned")
    void reassignment() {
        Variables variables = new Variables();
        assertDoesNotThrow(variables::reassignment, "You need to complete the assignment to pass the test");
    }

    @Test
    @Order(2)
    @DisplayName("Final variables cannot be reassigned")
    void finalVariables() {
        Variables variables = new Variables();
        assertDoesNotThrow(variables::finalVariables, "You need to complete the assignment to pass the test");
    }

    @Test
    @Order(3)
    @DisplayName("Copy vs Reference entities")
    void copyVsReference() {
        Variables variables = new Variables();
        assertDoesNotThrow(variables::copyVsReference, "You need to complete the assignment to pass the test");
    }
}