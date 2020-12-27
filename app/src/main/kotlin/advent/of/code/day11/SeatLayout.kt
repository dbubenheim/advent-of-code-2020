package advent.of.code.day11

internal interface SeatLayout {
    fun predict(): Int
    fun getUp(position: SeatPosition): Seat?
    fun getUpRight(position: SeatPosition): Seat?
    fun getRight(position: SeatPosition): Seat?
    fun getDownRight(position: SeatPosition): Seat?
    fun getDown(position: SeatPosition): Seat?
    fun getDownLeft(position: SeatPosition): Seat?
    fun getLeft(position: SeatPosition): Seat?
    fun getUpLeft(position: SeatPosition): Seat?
}
