import java.util.Arrays;

import static impl.Tools.ToDo;

public class Variables {
    public void reassignment() {
        int startingValue = ToDo("Assign an initial value");

        System.out.println("Value: " + startingValue);

        startingValue = ToDo("Assign another value");

        System.out.println("Value: " + startingValue);
    }

    public void finalVariables() {
        final int startingValue = ToDo("Assign an initial value");

        System.out.println("Value: " + startingValue);

        // NOTE the next lines are commented out because otherwise the code will not compile
//        startingValue = ToDo("Assign another value");
//        System.out.println("Value: " + startingValue);
    }


    public void copyVsReference() {
        System.out.println("Pass by copy");
        int variableA = ToDo("Assign an initial value");
        int variableB = variableA;

        System.out.println("Before:");
        System.out.println("\tvariableA = " + variableA);
        System.out.println("\tvariableB = " + variableB);

        variableA = ToDo("Assign another value");

        System.out.println("After:");
        System.out.println("\tvariableA = " + variableA);
        System.out.println("\tvariableB = " + variableB);

        System.out.println("\n-----------------");
        System.out.println("Pass by reference");
        int[] arrayA = ToDo("Assign an array with at least 5 elements");
        int[] arrayB = arrayA;


        System.out.println("Before:");
        System.out.println("\tarrayA = " + Arrays.toString(arrayA));
        System.out.println("\tarrayB = " + Arrays.toString(arrayB));

        arrayA[3] = ToDo("Assign another value to the 3th element. Remember arrays start from 0.");

        System.out.println("After:");
        System.out.println("\tarrayA = " + Arrays.toString(arrayA));
        System.out.println("\tarrayB = " + Arrays.toString(arrayB));
    }


}
