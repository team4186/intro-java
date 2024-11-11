import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

import static impl.Tools.ToDo;

public class ControlFlow {
    @NotNull
    public String callMe(@NotNull Callable<String> callback) {
        return ToDo("call the callback function");
    }

    @NotNull
    public Object useAnIf(boolean condition, @NotNull Object onTrue, @NotNull Object onFalse) {
        Object answer = null;
        ToDo("Use an if statement to assign `answer` with the correct value");

        System.out.println("You selected: " + answer);
        return answer;
    }

    public Object useASwitch(
            int value,
            @NotNull Callable<Object> option0,
            @NotNull Callable<Object> option1,
            @NotNull Callable<Object> option2,
            @NotNull Callable<Object> option3
    ) {
        Object answer = null;
        ToDo("""
                 Use a switch statement to assign `answer` with the value of the correct callable,
                 if no selection is good assign `null` to `answer`
                """);

        return answer;
    }

    public void useAFor(int repeatCount, @NotNull IntConsumer callback) {
        ToDo("Use a for statement to call `callback` `repeatCount` times");
    }

    public void useAForEach(@NotNull Collection<Object> elements, @NotNull Consumer<Object> callback) {
        ToDo("Use a for each statement to call `callback` over collection `elements`");
    }

    public void useAWhile(@NotNull Supplier<Boolean> predicate, @NotNull Runnable callback) {
        ToDo("Use a while statement to call `callback` while `predicate` is true");
    }
}
