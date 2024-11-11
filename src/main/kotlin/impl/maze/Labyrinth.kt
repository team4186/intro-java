package impl.maze

class Labyrinth(val cells: Array<String>) {
    companion object {
        const val ORIENTATION_180: Char = '←'
        const val ORIENTATION_90: Char = '↑'
        const val ORIENTATION_0: Char = '→'
        const val ORIENTATION_270: Char = '↓'
    }
}