package impl.maze;

public interface Commands {
    void stop();

    void move();

    void rotateClockwise();

    void rotateCounterClockwise();

    char peek();
}