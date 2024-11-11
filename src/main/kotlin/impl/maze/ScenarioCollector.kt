package impl.maze;

import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import maze.Maze;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface ScenarioCollector {
    static List<Pair<String, Function0<Scenario>>> collect() {
        return Arrays
                .stream(Maze.class.getDeclaredClasses())
                .filter((c) ->
                        Arrays
                                .stream(c.getInterfaces())
                                .anyMatch((i) ->
                                        i == Scenario.class
                                )
                )
                .map((c) -> {
                            try {
                                Constructor<?> constructor = c.getDeclaredConstructor();
                                return new Pair<String, Function0<Scenario>>(
                                        c.getSimpleName(),
                                        () -> {
                                            try {
                                                return (Scenario) constructor.newInstance();
                                            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                                                e.printStackTrace();
                                                return null;
                                            }
                                        }
                                );
                            } catch (NoSuchMethodException | SecurityException e) {
                                return null;
                            }
                        }
                )
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

    }
}
