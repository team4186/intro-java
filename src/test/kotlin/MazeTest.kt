import impl.maze.Runner;
import impl.maze.Scenario;
import maze.Maze;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("04-Mazes")
class MazeTest {
    @Test
    @Order(0)
    @DisplayName("Simple maze.Maze")
    void simple() {
        Maze.Simple maze = new Maze.Simple();
        Runner runner = run(maze);
        assertTrue(runner.isSolved());
    }

    @Test
    @Order(1)
    @DisplayName("Not so simple maze.Maze")
    void notSoSimple() {
        Maze.NotSoSimple maze = new Maze.NotSoSimple();
        Runner runner = run(maze);
        assertTrue(runner.isSolved());
    }

    @Test
    @Order(2)
    @DisplayName("Kinda Complex maze.Maze")
    void kindaComplex() {
        Maze.KindaComplex maze = new Maze.KindaComplex();
        Runner runner = run(maze);
        assertTrue(runner.isSolved());
    }

    @NotNull
    private Runner run(Scenario maze) {
        Runner runner = new Runner(maze);
        runner.run();
        return runner;
    }
}