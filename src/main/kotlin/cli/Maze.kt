@file:JvmName("Maze")
package cli

import impl.maze.Runner
import impl.maze.Scenario
import impl.maze.ScenarioCollector.collect
import java.io.PrintStream
import java.nio.charset.StandardCharsets
import java.util.*

fun main() {
    System.setOut(PrintStream(System.out, true, StandardCharsets.UTF_8))

    val scenarios: List<Pair<String, () -> Result<Scenario>>> = collect()
    var mainRunning = true
    while (mainRunning) {
        println("Select maze:")
        for ((name) in scenarios) {
            println("\t* $name")
        }

        val keyboard = Scanner(System.`in`)

        var entry: Pair<String?, () -> Result<Scenario>>? = null
        do {
            print("\n(Select Scenario)> ")
            val selected = keyboard.nextLine().trim { it <= ' ' }.lowercase(Locale.getDefault())
            for (e in scenarios) {
                if (e.first.lowercase(Locale.getDefault()) == selected) {
                    entry = e
                    break
                }
            }
        } while (entry == null)

        val scenario = entry.second.invoke()
        val runner = Runner(scenario.getOrThrow())
        var running = true
        while (running) {
            println("Running ----------------")
            for (y in runner.labyrinth.cells.indices) {
                print("\n")
                val line = runner.labyrinth.cells[y]
                for (x in line.indices) {
                    val robot = runner.robot()
                    if (x == robot.x && y == robot.y) {
                        print(robot.rotation)
                    } else {
                        var cell = line[x]
                        if (cell == '←' || cell == '↑' || cell == '→' || cell == '↓') {
                            cell = ' '
                        }
                        print(cell)
                    }
                }
            }

            if (runner.isSolved) {
                println("\nFinished!")
                running = false
            } else {
                print("\n(step | quit)> ")
                val command = keyboard.nextLine().trim { it <= ' ' }
                if (command.isBlank() || command == "step") {
                    runner.step()
                } else if (command == "quit") {
                    running = false
                    mainRunning = false
                }
            }
        }
    }
}

