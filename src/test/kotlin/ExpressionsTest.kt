import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import kotlin.test.*

internal class ExpressionsTest {
    private val expressions = Expressions()

    @Test
    fun `Create an expression that returns an integer 5`() {
        assertEquals(expressions.giveMe5(), 5)
    }

    @Test
    fun `Create an expression that returns a text 5`() {
        val valids = HashSet(
            mutableListOf(
                "Five",
                "five",
                "5"
            )
        )

        assertTrue(expressions.giveMeFive() in valids)
    }

    @Test
    fun `Create an expression that returns true`() {
        assertTrue(expressions.tellTheTrue())
    }

    @Test
    fun `Just call giveMe5 function inside your function`() {
        val expressions = spyk(Expressions())
        assertEquals(expressions.callGiveMe5(), 5)
        verify {
            expressions.callGiveMe5()
            expressions.giveMe5()
        }

        confirmVerified(expressions)
    }
}