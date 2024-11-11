package impl.maze;

public class Labyrinth {
    public static final char ORIENTATION_180 = '←';
    public static final char ORIENTATION_90 = '↑';
    public static final char ORIENTATION_0 = '→';
    public static final char ORIENTATION_270 = '↓';

    public final String[] cells;

    public Labyrinth(String[] cells) {
        this.cells = cells;
    }
}