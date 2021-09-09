import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("00-Types first part")
class TypesTest {
    @Test
    @Order(0)
    @DisplayName("Boolean Types")
    void booleans() {
        Types types = new Types();
        assertDoesNotThrow(types::booleans, "You need to complete the assignment to pass the test");
    }

    @Test
    @Order(1)
    @DisplayName("Integers Types")
    void integers() {
        Types types = new Types();
        assertDoesNotThrow(types::integers, "You need to complete the assignment to pass the test");
    }

    @Test
    @Order(2)
    @DisplayName("Floating Point numbers Types")
    void floats() {
        Types types = new Types();
        assertDoesNotThrow(types::floats, "You need to complete the assignment to pass the test");
    }

    @Test
    @Order(3)
    @DisplayName("Char and Strings")
    void text() {
        Types types = new Types();
        assertDoesNotThrow(types::floats, "You need to complete the assignment to pass the test");
    }

    @Test
    @Order(4)
    @DisplayName("Arrays")
    void arrays() {
        Types types = new Types();
        assertDoesNotThrow(types::arrays, "You need to complete the assignment to pass the test");
    }

}