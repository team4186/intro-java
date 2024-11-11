package impl.maze

interface Commands {
    fun stop()

    fun move()

    fun rotateClockwise()

    fun rotateCounterClockwise()

    fun peek(): Char
}