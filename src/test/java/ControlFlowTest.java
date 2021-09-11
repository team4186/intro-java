import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("03-Control Flow")
class ControlFlowTest {
    @Test
    @Order(0)
    @DisplayName("Call the callback")
    void callMe() {
        ControlFlow controlFlow = new ControlFlow();
        assertEquals(controlFlow.callMe(() -> "One"), "One");
        assertEquals(controlFlow.callMe(() -> "Two"), "Two");
        assertEquals(controlFlow.callMe(() -> "Three"), "Three");
    }

    @Test
    @Order(1)
    @DisplayName("Use an if statement to return the correct value")
    void useAnIf() {
        ControlFlow controlFlow = new ControlFlow();

        Object onTrue = "True";
        Object onFalse = "False";

        assertEquals(controlFlow.useAnIf(true, onTrue, onFalse), onTrue);
        assertEquals(controlFlow.useAnIf(false, onTrue, onFalse), onFalse);
    }

    @Test
    @Order(2)
    @DisplayName("Create a switch statement that returns the correct value or null if none found")
    void useASwitch() {
        ControlFlow controlFlow = new ControlFlow();

        Callable<Object> one = () -> "One";
        Callable<Object> two = () -> "Two";
        Callable<Object> three = () -> "Three";
        Callable<Object> four = () -> "Four";

        assertNull(controlFlow.useASwitch(0, one, two, three, four));
        assertEquals(controlFlow.useASwitch(1, one, two, three, four), "One");
        assertEquals(controlFlow.useASwitch(2, one, two, three, four), "Two");
        assertEquals(controlFlow.useASwitch(3, one, two, three, four), "Three");
        assertEquals(controlFlow.useASwitch(4, one, two, three, four), "Four");
        assertNull(controlFlow.useASwitch(5, one, two, three, four));
    }

    @Test
    @Order(3)
    @DisplayName("A simple for loop")
    void useAFor() {
        ControlFlow controlFlow = new ControlFlow();
        final int[] counter = {0};
        controlFlow.useAFor(4, (i) -> counter[0]++);
        assertEquals(counter[0], 4);
    }

    @Test
    @Order(4)
    @DisplayName("A simple foreach loop")
    void useAForEach() {
        ControlFlow controlFlow = new ControlFlow();
        List<Object> elements = Arrays.asList("0", "1", "2", "3");
        final String[] result = {""};
        controlFlow.useAForEach(elements, (element) -> result[0] += element);
        assertEquals(result[0], "0123");
    }

    @Test
    @Order(5)
    @DisplayName("A while loop")
    void useAWhile() {
        ControlFlow controlFlow = new ControlFlow();

        final int[] loops = {5};
        final int[] counter = {0};

        controlFlow.useAWhile(() -> loops[0]-- != 0, () -> counter[0]++);
        assertEquals(counter[0], 5);
    }
}