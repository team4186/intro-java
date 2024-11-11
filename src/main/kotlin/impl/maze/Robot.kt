package impl.maze;

public class Robot {
    public final int x;
    public final int y;
    public final char rotation;

    public Robot(int x, int y, char rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return "Robot{" + "x=" + x + ", y=" + y + ", rotation=" + rotation + '}';
    }
}