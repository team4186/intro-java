import impl.ToDo

class ControlFlow {
    fun callMe(callback: () -> String): String {
        return ToDo("call the callback function")
    }

    fun useAnIf(condition: Boolean, onTrue: Any, onFalse: Any): Any {
        val answer: Any = ToDo("Use an if statement to assign `answer` with the correct value")
        println("You selected: $answer")
        return answer
    }

    fun useASwitch(
        value: Int,
        option1: () -> Any,
        option2: () -> Any,
        option3: () -> Any,
        option4: () -> Any,
    ): Any? {
        val answer: Any? = ToDo(
            """
                 Use a when statement to assign `answer` with the value of the correct callable,
                 if no selection is good assign `null` to `answer`
                """.trimIndent()
        )

        return answer
    }

    fun useAFor(repeatCount: Int, callback: (Int) -> Unit) {
        ToDo<Unit>("Use a for statement to call `callback` `repeatCount` times")
    }

    fun useAForEach(elements: Collection<Any>, callback: (Any) -> Unit) {
        ToDo<Unit>("Use a for each statement to call `callback` over collection `elements`")
    }

    fun useAWhile(predicate: () -> Boolean, callback: () -> Unit) {
        ToDo<Unit>("Use a while statement to call `callback` while `predicate` is true")
    }
}
