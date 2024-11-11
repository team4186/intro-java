package impl.maze;

import org.jetbrains.annotations.NotNull;

public interface Scenario {
    String[] createMap();

    void step(@NotNull Robot robot, @NotNull Commands commands);
}

