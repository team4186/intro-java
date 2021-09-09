import static impl.Tools.ToDo;

public class Types {
    void booleans() {
        boolean aFalse = ToDo("Assign me with a false value");
        boolean aTrue = ToDo("Assign me with a true value");
    }

    void integers() {
        int aBinaryInteger = ToDo("Assign me with a binary formatted number");
        int anOctalInteger = ToDo("Assign me with an octal formatted number");
        int aHexInteger = ToDo("Assign me with a hexadecimal  formatted number");
        int aDecInteger = ToDo("Assign me with a decimal formatted number");

        long aSixtyFourBitInteger = ToDo("Assign me with a 64 bit number");
    }

    void floats() {
        float aThirtyTwoBitFloatingPoint = ToDo("Assign me with a 32 bit number");
        double aSixtyFourBitFloatingPoint = ToDo("Assign me with a 64 bit number");
    }

    void text() {
        char aChar = ToDo("Assign me with a char");
        String aString = ToDo("Assign me with a String");
    }

    void arrays() {
        int[] anArrayOfInt = ToDo("Assign me an array of Ints");
        double[] anArrayOfDoubles = ToDo("Assign me an array of Doubles");
        boolean[] anArrayOfBoolean = ToDo("Assign me an array of Booleans");
        String[] anArrayOfString = ToDo("Assign me an array of String");

        int[][] arrayOfArray = ToDo("Assign me an array of array of Ints");

        Object[] andArrayOfAnything = ToDo("Assign me an array of Anything");
    }
}
