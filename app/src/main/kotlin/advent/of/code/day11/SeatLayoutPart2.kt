package advent.of.code.day11

internal class SeatLayoutPart2(input: List<String>) : DefaultSeatLayout(input) {

    override fun getUp(position: SeatPosition): Seat? {
        var y = position.y
        while (--y >= 0) {
            val up = seats[y][position.x]
            if (up.isSeat()) return up
        }
        return null
    }

    override fun getUpRight(position: SeatPosition): Seat? {
        var x = position.x
        var y = position.y
        while (++x <= seats.first().lastIndex && --y >= 0) {
            val upRight = seats[y][x]
            if (upRight.isSeat()) return upRight
        }
        return null
    }

    override fun getRight(position: SeatPosition): Seat? {
        var x = position.x
        while (++x <= seats.first().lastIndex) {
            val right = seats[position.y][x]
            if (right.isSeat()) return right
        }
        return null
    }

    override fun getDownRight(position: SeatPosition): Seat? {
        var x = position.x
        var y = position.y
        while (++x <= seats.first().lastIndex && ++y <= seats.lastIndex) {
            val downRight = seats[y][x]
            if (downRight.isSeat()) return downRight
        }
        return null
    }

    override fun getDown(position: SeatPosition): Seat? {
        var y = position.y
        while (++y <= seats.lastIndex) {
            val down = seats[y][position.x]
            if (down.isSeat()) return down
        }
        return null
    }

    override fun getDownLeft(position: SeatPosition): Seat? {
        var x = position.x
        var y = position.y
        while (--x >= 0 && ++y <= seats.lastIndex) {
            val downLeft = seats[y][x]
            if (downLeft.isSeat()) return downLeft
        }
        return null
    }

    override fun getLeft(position: SeatPosition): Seat? {
        var x = position.x
        while (--x >= 0) {
            val downLeft = seats[position.y][x]
            if (downLeft.isSeat()) return downLeft
        }
        return null
    }

    override fun getUpLeft(position: SeatPosition): Seat? {
        var x = position.x
        var y = position.y
        while (--x >= 0 && --y >= 0) {
            val upLeft = seats[y][x]
            if (upLeft.isSeat()) return upLeft
        }
        return null
    }

    override fun predictUpdate(seat: Seat) {
        when (seat.type) {
            SeatType.FLOOR -> { }
            SeatType.EMPTY -> if (noOccupiedSeatsAround(seat.position)) {
                seat.update = SeatUpdate(SeatType.OCCUPIED)
            }
            SeatType.OCCUPIED -> if (countOccupiedSeatsAround(seat.position) >= 5) {
                seat.update = SeatUpdate(SeatType.EMPTY)
            }
        }
    }
}