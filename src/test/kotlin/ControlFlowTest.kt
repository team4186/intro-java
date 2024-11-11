import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class ControlFlowTest {
    @Test
    fun `Call the callback`() {
        val controlFlow = ControlFlow()
        assertEquals("One", controlFlow.callMe { "One" })
        assertEquals("Two", controlFlow.callMe { "Two" })
        assertEquals("Three", controlFlow.callMe { "Three" })
    }

    @Test
    fun `Use an if statement to return the correct value`() {
        val controlFlow = ControlFlow()

        val onTrue: Any = "True"
        val onFalse: Any = "False"

        assertEquals(onTrue, controlFlow.useAnIf(true, onTrue, onFalse))
        assertEquals(onFalse, controlFlow.useAnIf(false, onTrue, onFalse))
    }

    @Test
    fun `Create a switch statement that returns the correct value or null if none found`() {
        val controlFlow = ControlFlow()

        val one = { "One" }
        val two = { "Two" }
        val three = { "Three" }
        val four = { "Four" }

        assertNull(controlFlow.useASwitch(0, one, two, three, four))
        assertEquals("One", controlFlow.useASwitch(1, one, two, three, four))
        assertEquals("Two", controlFlow.useASwitch(2, one, two, three, four))
        assertEquals("Three", controlFlow.useASwitch(3, one, two, three, four))
        assertEquals("Four", controlFlow.useASwitch(4, one, two, three, four))
        assertNull(controlFlow.useASwitch(5, one, two, three, four))
    }

    @Test
    fun `A simple for loop`() {
        val controlFlow = ControlFlow()
        val counter = intArrayOf(0)
        controlFlow.useAFor(4) { i: Int -> counter[0]++ }
        assertEquals(counter[0], 4)
    }

    @Test
    fun `A simple foreach loop`() {
        val controlFlow = ControlFlow()
        val elements: List<Any> = mutableListOf<Any>("0", "1", "2", "3")
        val result = buildString {
            controlFlow.useAForEach(elements) { element: Any -> append(element) }
        }
        assertEquals("0123", result)
    }

    @Test
    fun `A while loop`() {
        val controlFlow = ControlFlow()

        val loops = intArrayOf(5)
        val counter = intArrayOf(0)

        controlFlow.useAWhile({ loops[0]-- != 0 }, { counter[0]++ })
        assertEquals(5, counter[0])
    }
}