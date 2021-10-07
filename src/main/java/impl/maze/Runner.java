package impl.maze;

import org.jetbrains.annotations.NotNull;

public class Runner {
    public final Labyrinth labyrinth;
    private Robot robot;
    private final Scenario scenario;
    private final CommandsRecorder recorder = new CommandsRecorder();

    private boolean solved = false;
    private int idleCount = 0;
    private static final int MAX_IDLE = 5;

    public Runner(@NotNull Scenario scenario) {
        labyrinth = new Labyrinth(scenario.createMap());
        robot = initRobot(labyrinth);
        this.scenario = scenario;
    }

    public Robot robot() {
        return robot;
    }

    public boolean isSolved() {
        return solved;
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            step();

            if (idleCount > MAX_IDLE || solved) {
                isRunning = false;
            }
        }
    }

    @NotNull
    public Robot step() {
        recorder.move = false;
        recorder.rotate = 0;
        scenario.step(robot, recorder);

        final char rotation = rotate(robot, recorder.rotate);

        if (recorder.move) {
            int x = robot.x, y = robot.y;
            switch (robot.rotation) {
                case '←' -> x--;
                case '↑' -> y--;
                case '→' -> x++;
                case '↓' -> y++;
            }
            // TODO guard ranges
            switch (labyrinth.cells[y].charAt(x)) {
                case '#' -> {
                    idleCount += 1;
                    robot = new Robot(robot.x, robot.y, rotation);
                }
                case 'x' -> {
                    idleCount = 0;
                    solved = true;
                    robot = new Robot(x, y, rotation);
                }
                default -> {
                    idleCount = 0;
                    robot = new Robot(x, y, rotation);
                }
            }
        } else if (recorder.rotate == 0) {
            idleCount += 1;
        } else {
            idleCount += 1;
            robot = new Robot(robot.x, robot.y, rotation);
        }

        return robot;
    }

    @NotNull
    private static Robot initRobot(@NotNull Labyrinth labyrinth) {
        String[] cells = labyrinth.cells;
        for (int y = 0; y < cells.length; y++) {
            String line = cells[y];
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);

                switch (c) {
                    case Labyrinth.ORIENTATION_180:
                    case Labyrinth.ORIENTATION_90:
                    case Labyrinth.ORIENTATION_0:
                    case Labyrinth.ORIENTATION_270:
                        return new Robot(x, y, c);
                }
            }
        }
        throw new IllegalArgumentException("Map does not have a robot in it");
    }

    private static char rotate(@NotNull Robot robot, int direction) {
        return (char) (((4 + (robot.rotation - Labyrinth.ORIENTATION_180) + direction) % 4) + Labyrinth.ORIENTATION_180);
    }

    private class CommandsRecorder implements Commands {
        boolean move = false;
        int rotate = 0;

        @Override
        public void stop() {
            move = false;
            rotate = 0;
        }

        @Override
        public void move() {
            move = true;
        }

        @Override
        public void rotateClockwise() {
            rotate = 1;
        }

        @Override
        public void rotateCounterClockwise() {
            rotate = -1;
        }

        @Override
        public char peek() {
            int x = robot.x, y = robot.y;
            switch (robot.rotation) {
                case '←' -> x--;
                case '↑' -> y--;
                case '→' -> x++;
                case '↓' -> y++;
            }

            return labyrinth.cells[y].charAt(x);
        }
    }
}