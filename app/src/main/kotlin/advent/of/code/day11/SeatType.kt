package advent.of.code.day11

internal enum class SeatType(private val char: Char) {

    EMPTY('L'),
    FLOOR('.'),
    OCCUPIED('#');

    override fun toString() = "$char"

    companion object {
        fun of(char: Char) = values().first { it.char == char }
    }
}