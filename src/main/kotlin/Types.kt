import impl.ToDo

class Types {
    fun booleans() {
        val aFalse: Boolean = ToDo("Assign me with a false value")
        val aTrue: Boolean = ToDo("Assign me with a true value")
    }

    fun integers() {
        val aBinaryInteger: Int = ToDo("Assign me with a binary formatted number")
        val aHexInteger: Int = ToDo("Assign me with a hexadecimal  formatted number")
        val aDecInteger: Int = ToDo("Assign me with a decimal formatted number")

        val aSixtyFourBitInteger: Long = ToDo("Assign me with a 64 bit number")
    }

    fun floats() {
        val aThirtyTwoBitFloatingPoint: Float = ToDo("Assign me with a 32 bit number")
        val aSixtyFourBitFloatingPoint: Double = ToDo("Assign me with a 64 bit number")
    }

    fun text() {
        val aChar: Char = ToDo("Assign me with a char")
        val aString: String = ToDo("Assign me with a String")
    }

    fun arrays() {
        val anArrayOfInt: IntArray = ToDo("Assign me an array of Ints")
        val anArrayOfDoubles: DoubleArray = ToDo("Assign me an array of Doubles")
        val anArrayOfBoolean: BooleanArray = ToDo("Assign me an array of Booleans")
        val anArrayOfString: Array<String> = ToDo("Assign me an array of String")

        val arrayOfArray: Array<IntArray> = ToDo("Assign me an array of array of Ints")

        val andArrayOfAnything: Array<Any> = ToDo("Assign me an array of Anything")
    }
}
