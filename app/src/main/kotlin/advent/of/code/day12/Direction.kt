package advent.of.code.day12

enum class Direction(val degrees: Int) {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    companion object {
        fun of(degrees: Int) = values().first { it.degrees == degrees }
    }
}