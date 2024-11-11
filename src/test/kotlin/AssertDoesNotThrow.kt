import kotlin.test.fail

inline fun assertDoesNotThrow(block: ()->Unit) {
    try {
        block()
    } catch (_: Throwable) {
        fail("You need to complete the assignment to pass the test")
    }
}