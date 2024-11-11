import org.jetbrains.annotations.NotNull;

import static impl.Tools.ToDo;

/**
 * All solutions should be a single line expression
 */
public class Expressions {
    public int giveMe5() {
        return ToDo("Create an expression that returns a 5");
    }

    @NotNull
    public String giveMeFive() {
        return ToDo("Create an expression that returns a Five");
    }

    public boolean tellTheTrue() {
        return ToDo("Create an expression that returns true");
    }

    @NotNull
    public Object useTheTernary(boolean predicate, @NotNull Object onTrue, @NotNull Object onFalse) {
        return ToDo("Use the ternary operator to return the correct answer");
    }

    public int callGiveMe5() {
        return ToDo("call the function giveMe5()");
    }
}
