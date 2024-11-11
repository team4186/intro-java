package apps;

import impl.maze.ScenarioCollector;

public class MazeApp {
    public static void main(String[] args) {
        ui.EntryPointKt.main(ScenarioCollector.collect());
    }
}
