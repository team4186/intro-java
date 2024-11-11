import kotlin.test.*

internal class VariablesTest {
    private val variables = Variables()

    @Test
    fun `Variables can be reassigned`() {
        assertDoesNotThrow { variables.reassignment() }
    }

    @Test
    fun `Final variables cannot be reassigned`() {
        assertDoesNotThrow { variables.finalVariables() }
    }

    @Test
    fun `Copy vs Reference entities`() {
        assertDoesNotThrow { variables.copyVsReference() }
    }

}