package maze;

import impl.maze.Commands;
import impl.maze.Robot;
import impl.maze.Scenario;
import org.jetbrains.annotations.NotNull;

import static impl.Tools.ToDo;

public interface Maze {

    class Simple implements Scenario {
        @Override
        public String[] createMap() {
            return new String[]{
                    "#######",
                    "#→   x#",
                    "#######"
            };
        }

        @Override
        public void step(@NotNull Robot robot, @NotNull Commands commands) {
            ToDo("Make the arrow reach the X");
        }
    }

    class NotSoSimple implements Scenario {
        @Override
        public String[] createMap() {
            return new String[]{
                    "#######",
                    "#→    #",
                    "#     #",
                    "#     #",
                    "#    x#",
                    "#######",
            };
        }

        @Override
        public void step(@NotNull Robot robot, @NotNull Commands commands) {
            ToDo("Make the arrow reach the X");
        }
    }

    class KindaComplex implements Scenario {
        @Override
        public String[] createMap() {
            return new String[]{
                    "######      ###",
                    "#→   #      #x#",
                    "#### # ###### #",
                    "   # ###      #",
                    "   #     ######",
                    "   #######     "
            };
        }

        @Override
        public void step(@NotNull Robot robot, @NotNull Commands commands) {
            ToDo("Make the arrow reach the X");
        }
    }

    class Complex implements Scenario {
        @Override
        public String[] createMap() {
            return new String[]{
                    "######### ###",
                    "#→      # #x#",
                    "#### ## # # #",
                    "   # ## # # #",
                    "   #    # # #",
                    "   ### #### #",
                    "     #      #",
                    "     ########"
            };
        }

        @Override
        public void step(@NotNull Robot robot, @NotNull Commands commands) {
            ToDo("Make the arrow reach the X");
        }
    }

}
