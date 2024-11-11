package impl.maze

import maze.Maze

object ScenarioCollector {
    fun collect(): List<Pair<String, () -> Result<Scenario>>> {
        return Maze::class
            .java
            .declaredClasses
            .filter { c -> c.interfaces.any { i -> i == Scenario::class.java } }
            .mapNotNull { klass ->
                klass
                    .getDeclaredConstructor()
                    .let { { it.runCatching { newInstance() as Scenario } } }
                    .let { klass.simpleName to it }
            }
            .toList()
    }
}
