package impl.maze

class Runner(scenario: Scenario) {
    val labyrinth: Labyrinth = Labyrinth(scenario.createMap())
    private var robot: Robot
    private val scenario: Scenario
    private val recorder = CommandsRecorder()

    var isSolved: Boolean = false
        private set
    private var idleCount = 0

    init {
        robot = initRobot(labyrinth)
        this.scenario = scenario
    }

    fun robot(): Robot {
        return robot
    }

    fun run() {
        var isRunning = true

        while (isRunning) {
            step()

            if (idleCount > MAX_IDLE || isSolved) {
                isRunning = false
            }
        }
    }

    fun step(): Robot {
        recorder.move = false
        recorder.rotate = 0
        scenario.step(robot, recorder)

        val rotation = rotate(robot, recorder.rotate)

        if (recorder.move) {
            var x = robot.x
            var y = robot.y
            when (robot.rotation) {
                '←' -> x--
                '↑' -> y--
                '→' -> x++
                '↓' -> y++
            }
            // TODO guard ranges
            when (labyrinth.cells[y][x]) {
                '#' -> {
                    idleCount += 1
                    robot = Robot(robot.x, robot.y, rotation)
                }

                'x' -> {
                    idleCount = 0
                    isSolved = true
                    robot = Robot(x, y, rotation)
                }

                else -> {
                    idleCount = 0
                    robot = Robot(x, y, rotation)
                }
            }
        } else if (recorder.rotate == 0) {
            idleCount += 1
        } else {
            idleCount += 1
            robot = Robot(robot.x, robot.y, rotation)
        }

        return robot
    }

    private inner class CommandsRecorder : Commands {
        var move: Boolean = false
        var rotate: Int = 0

        override fun stop() {
            move = false
            rotate = 0
        }

        override fun move() {
            move = true
        }

        override fun rotateClockwise() {
            rotate = 1
        }

        override fun rotateCounterClockwise() {
            rotate = -1
        }

        override fun peek(): Char {
            var x = robot.x
            var y = robot.y
            when (robot.rotation) {
                '←' -> x--
                '↑' -> y--
                '→' -> x++
                '↓' -> y++
            }

            return labyrinth.cells[y][x]
        }
    }

    companion object {
        private const val MAX_IDLE = 5

        private fun initRobot(labyrinth: Labyrinth): Robot {
            val cells = labyrinth.cells
            for (y in cells.indices) {
                val line = cells[y]
                for (x in line.indices) {
                    when (val c = line[x]) {
                        Labyrinth.ORIENTATION_180, Labyrinth.ORIENTATION_90, Labyrinth.ORIENTATION_0, Labyrinth.ORIENTATION_270 -> return Robot(
                            x,
                            y,
                            c
                        )
                    }
                }
            }
            throw IllegalArgumentException("Map does not have a robot in it")
        }

        private fun rotate(robot: Robot, direction: Int): Char {
            return (((4 + (robot.rotation.code - Labyrinth.ORIENTATION_180.code) + direction) % 4) + Labyrinth.ORIENTATION_180.code).toChar()
        }
    }
}