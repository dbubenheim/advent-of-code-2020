package advent.of.code.day11

internal class SeatLayoutPart1(input: List<String>) : DefaultSeatLayout(input) {

    override fun getUp(position: SeatPosition): Seat? {
        if (position.y == 0) return null
        return seats[position.y - 1][position.x]
    }

    override fun getUpRight(position: SeatPosition): Seat? {
        if (position.x == seats.first().lastIndex || position.y == 0) return null
        return seats[position.y - 1][position.x + 1]
    }

    override fun getRight(position: SeatPosition): Seat? {
        if (position.x == seats.first().lastIndex) return null
        return seats[position.y][position.x + 1]
    }

    override fun getDownRight(position: SeatPosition): Seat? {
        if (position.x == seats.first().lastIndex || position.y == seats.lastIndex) return null
        return seats[position.y + 1][position.x + 1]
    }

    override fun getDown(position: SeatPosition): Seat? {
        if (position.y == seats.lastIndex) return null
        return seats[position.y + 1][position.x]
    }

    override fun getDownLeft(position: SeatPosition): Seat? {
        if (position.x == 0 || position.y == seats.lastIndex) return null
        return seats[position.y + 1][position.x - 1]
    }

    override fun getLeft(position: SeatPosition): Seat? {
        if (position.x == 0) return null
        return seats[position.y][position.x - 1]
    }

    override fun getUpLeft(position: SeatPosition): Seat? {
        if (position.x == 0 || position.y == 0) return null
        return seats[position.y - 1][position.x - 1]
    }

    override fun predictUpdate(seat: Seat) {
        when (seat.type) {
            SeatType.FLOOR -> { }
            SeatType.EMPTY -> if (noOccupiedSeatsAround(seat.position)) {
                seat.update = SeatUpdate(SeatType.OCCUPIED)
            }
            SeatType.OCCUPIED -> if (countOccupiedSeatsAround(seat.position) >= 4) {
                seat.update = SeatUpdate(SeatType.EMPTY)
            }
        }
    }
}