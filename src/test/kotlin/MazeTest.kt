import impl.maze.Runner
import impl.maze.Scenario
import maze.Maze.*
import kotlin.test.Test
import kotlin.test.assertTrue

internal class MazeTest {
    @Test
    fun `Simple Maze`() {
        assertTrue(run(Simple()).isSolved)
    }

    @Test
    fun `Not so simple maze`() {
        assertTrue(run(NotSoSimple()).isSolved)
    }

    @Test
    fun `Kinda Complex maze`() {
        assertTrue(run(KindaComplex()).isSolved)
    }

    private fun run(maze: Scenario): Runner {
        val runner = Runner(maze)
        runner.run()
        return runner
    }
}