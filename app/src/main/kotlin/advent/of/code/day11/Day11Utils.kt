package advent.of.code.day11

internal fun List<String>.toSeatLayoutPart1(): DefaultSeatLayout {
    return SeatLayoutPart1(this)
}

internal fun List<String>.toSeatLayoutPart2(): DefaultSeatLayout {
    return SeatLayoutPart2(this)
}

internal fun Char.toSeatType() = SeatType.of(this)

