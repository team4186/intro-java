import kotlin.test.Test

internal class TypesTest {
    private val types = Types()

    @Test
    fun `Boolean Types`() {
        assertDoesNotThrow { types.booleans() }
    }

    @Test
    fun `Integers Types`() {
        assertDoesNotThrow { types.integers() }
    }

    @Test
    fun `Floating Point numbers Types`() {
        assertDoesNotThrow { types.floats() }
    }

    @Test
    fun `Char and Strings`() {
        assertDoesNotThrow { types.text() }
    }

    @Test
    fun `Arrays and collections`() {
        assertDoesNotThrow { types.arrays() }
    }
}