package advent.of.code

import advent.of.code.SeatType.*
import java.io.File

internal class Day11 {

    companion object {

        @JvmStatic
        fun part1(): Int {
            val seatLayout = File("day11/input-day11.txt".toURL()).readLines().toSeatLayout()
            println(seatLayout.toString())

            var rounds = 0
            var updated: Boolean
            do {
                println("round: $rounds")
                updated = seatLayout.update()
                println(seatLayout.toString())
                rounds++
            } while (updated)

            println("total rounds: $rounds")
            println(seatLayout.toString())
            return seatLayout.occupiedSeats
        }

        @JvmStatic
        fun part2(): Int {
            return 0
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("part1: ${part1()}")
            println("part2: ${part2()}")
        }
    }
}

private fun List<String>.toSeatLayout(): SeatLayout {
    return SeatLayout(this)
}

class SeatLayout(input: List<String>) {

    // rows -> columns
    private val seats: List<List<Seat>> = input.mapIndexed { y, row ->
        row.toCharArray().mapIndexed { x, character ->
            Seat(character, this, SeatPosition(x, y))
        }
    }
    //val columns : List<List<Seat>>

    val occupiedSeats
        get() = seats.flatten().count { it.isOccupied() }

    val emptySeats
        get() = seats.flatten().count { it.isEmpty() }

    val floorSeats
        get() = seats.flatten().count { it.isFloor() }

    fun update(): Boolean {
        var result = false
        seats.forEach { row ->
            row.forEach { seat ->
                val updated = seat.update()
                if (updated) result = true
            }
        }
        return result
    }

    override fun toString() = seats.joinToString("\n") { it.toString() }

    internal fun getUp(position: SeatPosition): Seat? {
        if (position.y == 0) return null
        return seats[position.x][position.y - 1]
    }

    internal fun getUpRight(position: SeatPosition): Seat? {
        if (position.x == seats.first().lastIndex) return null
        return seats[position.x + 1][position.y]
    }

    internal fun getRight(position: SeatPosition): Seat? {
        if (position.x == seats.first().lastIndex || position.y == seats.lastIndex) return null
        return seats[position.x + 1][position.y + 1]
    }

    internal fun getDownRight(position: SeatPosition): Seat? {
        if (position.x == seats.lastIndex || position.y == 0) return null
        return seats[position.x + 1][position.y - 1]
    }

    internal fun getDown(position: SeatPosition): Seat? {
        if (position.y == seats.lastIndex) return null
        return seats[position.x][position.y + 1]
    }

    internal fun getDownLeft(position: SeatPosition): Seat? {
        if (position.x == 0 || position.y == seats.lastIndex) return null
        return seats[position.x - 1][position.y + 1]
    }

    internal fun getLeft(position: SeatPosition): Seat? {
        if (position.x == 0) return null
        return seats[position.x - 1][position.y]
    }

    internal fun getUpLeft(position: SeatPosition): Seat? {
        if (position.x == 0 || position.y == 0) return null
        return seats[position.x - 1][position.y - 1]
    }
}

//class Seats() : EnumSet<Seat> {
//
//}

enum class SeatType(private val char: Char) {

    EMPTY('L'),
    FLOOR('.'),
    OCCUPIED('#');

    companion object {
        fun of(char: Char) = values().first { it.char == char }
    }
}

internal class Seat(
    char: Char,
    private val layout: SeatLayout,
    private val position: SeatPosition
) {

    var type = SeatType.of(char)

    val up: Seat?
        get() = layout.getUp(this.position)
    val upRight: Seat?
        get() = layout.getUpRight(this.position)
    val right: Seat?
        get() = layout.getRight(this.position)
    val downRight: Seat?
        get() = layout.getDownRight(this.position)
    val down: Seat?
        get() = layout.getDown(this.position)
    val downLeft: Seat?
        get() = layout.getDownLeft(this.position)
    val left: Seat?
        get() = layout.getLeft(this.position)
    val upLeft: Seat?
        get() = layout.getUpLeft(this.position)

    fun occupiedSeatsAround() = countOccupiedSeatsAround() > 0

    fun noOccupiedSeatsAround() = !occupiedSeatsAround()

    fun countOccupiedSeatsAround(): Int {
        var count = 0
        if (up?.isOccupied() == true) count++
        if (upRight?.isOccupied() == true) count++
        if (right?.isOccupied() == true) count++
        if (downRight?.isOccupied() == true) count++
        if (down?.isOccupied() == true) count++
        if (downLeft?.isOccupied() == true) count++
        if (left?.isOccupied() == true) count++
        if (upLeft?.isOccupied() == true) count++
        return count
    }

    fun update(): Boolean {
        var updated = false
        when (this.type) {
            FLOOR -> doNothing()
            EMPTY -> if (noOccupiedSeatsAround()) {
                this.type = OCCUPIED
                updated = true
            }
            OCCUPIED -> if (countOccupiedSeatsAround() == 4) {
                this.type = EMPTY
                updated = true
            }
        }
        return updated
    }

    fun isOccupied() = this.type == OCCUPIED
    fun isEmpty() = this.type == EMPTY
    fun isFloor() = this.type == FLOOR

    override fun toString() = this.type.toString()

    private fun doNothing() {}
}

internal data class SeatPosition(val x: Int, val y: Int)
