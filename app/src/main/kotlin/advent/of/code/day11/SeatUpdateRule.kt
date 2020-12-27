package advent.of.code.day11

internal interface SeatUpdateRule {
    fun predictUpdate(seat: Seat)
}