package advent.of.code.day12

enum class Action(val char: Char) {

    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W'),
    LEFT('L'),
    RIGHT('R'),
    FORWARD('F');

    companion object {
        fun of(char: Char) = values().first { it.char == char }
    }
}