package maze

import impl.maze.Scenario


interface Maze {
    class Simple : Scenario {
        override fun createMap(): Array<String> {
            return arrayOf(
                "#######",
                "#→   x#",
                "#######"
            )
        }

        override fun step(robot: impl.maze.Robot, commands: impl.maze.Commands) {
            TODO("Make the arrow reach the X")
//            commands.move()
        }
    }

    class NotSoSimple : Scenario {
        override fun createMap(): Array<String> {
            return arrayOf(
                "#######",
                "#→    #",
                "#     #",
                "#     #",
                "#    x#",
                "#######",
            )
        }

        override fun step(robot: impl.maze.Robot, commands: impl.maze.Commands) {
            TODO("Make the arrow reach the X")
        }
    }

    class KindaComplex : Scenario {
        override fun createMap(): Array<String> {
            return arrayOf(
                "######      ###",
                "#→   #      #x#",
                "#### # ###### #",
                "   # ###      #",
                "   #     ######",
                "   #######     "
            )
        }

        override fun step(robot: impl.maze.Robot, commands: impl.maze.Commands) {
            TODO("Make the arrow reach the X")
        }
    }

    class Complex : Scenario {
        override fun createMap(): Array<String> {
            return arrayOf(
                "######### ###",
                "#→      # #x#",
                "#### ## # # #",
                "   # ## # # #",
                "   #    # # #",
                "   ### #### #",
                "     #      #",
                "     ########"
            )
        }

        override fun step(robot: impl.maze.Robot, commands: impl.maze.Commands) {
            TODO("Make the arrow reach the X")
        }
    }
}
