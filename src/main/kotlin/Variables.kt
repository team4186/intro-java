import impl.ToDo

class Variables {
    fun reassignment() {
        var startingValue = ToDo<Any>("Assign an initial value")

        println("Value: $startingValue")

        startingValue = ToDo("Assign another value")

        println("Value: $startingValue")
    }

    fun finalVariables() {
        val startingValue = ToDo<Int>("Assign an initial value")

        println("Value: $startingValue")

        // NOTE the next lines are commented out because otherwise the code will not compile
//        startingValue = ToDo("Assign another value");
//        System.out.println("Value: " + startingValue);
    }


    fun copyVsReference() {
        println("Pass by copy")
        var variableA = ToDo<Int>("Assign an initial value")
        val variableB = variableA

        println("Before:")
        println("\tvariableA = $variableA")
        println("\tvariableB = $variableB")

        variableA = ToDo("Assign another value")

        println("After:")
        println("\tvariableA = $variableA")
        println("\tvariableB = $variableB")

        println("\n-----------------")
        println("Pass by reference")
        val arrayA = ToDo<IntArray>("Assign an array with at least 5 elements")
        val arrayB = arrayA


        println("Before:")
        println("\tarrayA = " + arrayA.contentToString())
        println("\tarrayB = " + arrayB.contentToString())

        arrayA[3] = ToDo("Assign another value to the 3th element. Remember arrays start from 0.")

        println("After:")
        println("\tarrayA = " + arrayA.contentToString())
        println("\tarrayB = " + arrayB.contentToString())
    }
}
