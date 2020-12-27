package advent.of.code.day11

abstract class DefaultSeatLayout(input: List<String>) : SeatLayout, SeatUpdateRule {

    // rows -> columns
    internal val seats: List<List<Seat>> = input.mapIndexed { y, row ->
        row.toCharArray().mapIndexed { x, character ->
            Seat(character.toSeatType(), SeatPosition(x, y))
        }
    }

    val allSeats
        get() = seats.flatten().count()

    private val occupiedSeats
        get() = seats.flatten().count { it.isOccupied() }

    override fun predict(): Int {
        //println(seatLayout.toString())
        var rounds = 0
        var updated: Boolean
        do {
            println("round: $rounds")
            updated = update()
            //println(seatLayout.toString())
            rounds++
        } while (updated)

        println("total rounds: $rounds")
        //println(seatLayout.toString())
        return occupiedSeats
    }

    override fun toString() =
        seats.joinToString("\n") { it.joinToString(" ") }

    internal fun noOccupiedSeatsAround(position: SeatPosition) = !occupiedSeatsAround(position)

    internal fun countOccupiedSeatsAround(position: SeatPosition): Int {
        var count = 0
        if (getUp(position)?.isOccupied() == true) count++
        if (getUpRight(position)?.isOccupied() == true) count++
        if (getRight(position)?.isOccupied() == true) count++
        if (getDownRight(position)?.isOccupied() == true) count++
        if (getDown(position)?.isOccupied() == true) count++
        if (getDownLeft(position)?.isOccupied() == true) count++
        if (getLeft(position)?.isOccupied() == true) count++
        if (getUpLeft(position)?.isOccupied() == true) count++
        return count
    }

    private fun occupiedSeatsAround(position: SeatPosition) = countOccupiedSeatsAround(position) > 0

    private fun update(): Boolean {
        var result = false

        seats.forEach { row ->
            row.forEach { seat ->
                predictUpdate(seat)
                if (seat.needsUpdate()) result = true
            }
        }

        seats.forEach { row ->
            row.forEach { seat ->
                seat.update()
            }
        }

        return result
    }
}
