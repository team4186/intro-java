package apps;

import impl.maze.Robot;
import impl.maze.Runner;
import impl.maze.Scenario;
import impl.maze.ScenarioCollector;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

import java.util.List;
import java.util.Scanner;

public class MazeCLI {
    public static void main(String[] args) {
        List<Pair<String, Function0<Scenario>>> scenarios = ScenarioCollector.collect();
        boolean mainRunning = true;
        while (mainRunning) {
            System.out.println("Select maze:");
            for (Pair<String, Function0<Scenario>> entry : scenarios) {
                String name = entry.getFirst();
                System.out.println("\t* " + name);
            }

            Scanner keyboard = new Scanner(System.in);

            Pair<String, Function0<Scenario>> entry = null;
            do {
                System.out.print("\n(Select Scenario)> ");
                String selected = keyboard.nextLine().trim().toLowerCase();
                for (Pair<String, Function0<Scenario>> e : scenarios) {
                    if (e.getFirst().toLowerCase().equals(selected)) {
                        entry = e;
                        break;
                    }
                }
            }
            while (entry == null);

            Scenario scenario = entry.getSecond().invoke();
            Runner runner = new Runner(scenario);
            boolean running = true;
            while (running) {
                System.out.println("Running ----------------");
                for (int y = 0; y < runner.labyrinth.cells.length; ++y) {
                    System.out.print("\n");
                    String line = runner.labyrinth.cells[y];
                    for (int x = 0; x < line.length(); ++x) {
                        Robot robot = runner.robot();
                        if (x == robot.x && y == robot.y) {
                            System.out.print(robot.rotation);
                        } else {
                            char cell = line.charAt(x);
                            if (cell == '←' || cell == '↑' || cell == '→' || cell == '↓') {
                                cell = ' ';
                            }
                            System.out.print(cell);
                        }
                    }
                }

                if (runner.isSolved()) {
                    System.out.println("\nFinished!");
                    running = false;
                } else {
                    System.out.print("\n(step | quit)> ");
                    String command = keyboard.nextLine().trim();
                    if (command.isBlank() || command.equals("step")) {
                        runner.step();
                    } else if (command.equals("quit")) {
                        running = false;
                        mainRunning = false;
                    }
                }
            }

        }
    }
}
