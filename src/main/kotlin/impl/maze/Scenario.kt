package impl.maze

interface Scenario {
    fun createMap(): Array<String>

    fun step(robot: Robot, commands: Commands)
}

