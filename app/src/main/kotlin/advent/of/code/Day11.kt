package advent.of.code

import advent.of.code.SeatType.*
import java.io.File

internal class Day11 {

    companion object {

        @JvmStatic
        internal fun part1(): Int {
            val seatLayout = File("day11/input-day11-2.txt".toURL()).readLines().toSeatLayout()
            //println(seatLayout.toString())

            var rounds = 0
            var updated: Boolean
            do {
                println("round: $rounds")
                updated = seatLayout.update()
                //println(seatLayout.toString())
                rounds++
            } while (updated)

            println("total rounds: $rounds")
            //println(seatLayout.toString())
            return seatLayout.occupiedSeats
        }

        @JvmStatic
        internal fun part2(): Int {
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

    internal fun update(): Boolean {
        var result = false
        seats.forEach { row ->
            row.forEach { seat ->
                seat.checkUpdate()
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

    override fun toString() = seats.joinToString("\n") { it.joinToString(" ") }

    internal fun getUp(position: SeatPosition): Seat? {
        if (position.y == 0) return null
        return seats[position.y - 1][position.x]
    }

    internal fun getUpRight(position: SeatPosition): Seat? {
        if (position.x == seats.first().lastIndex || position.y == 0) return null
        return seats[position.y - 1][position.x + 1]
    }

    internal fun getRight(position: SeatPosition): Seat? {
        if (position.x == seats.first().lastIndex) return null
        return seats[position.y][position.x + 1]
    }

    internal fun getDownRight(position: SeatPosition): Seat? {
        if (position.x == seats.first().lastIndex || position.y == seats.lastIndex) return null
        return seats[position.y + 1][position.x + 1]
    }

    internal fun getDown(position: SeatPosition): Seat? {
        if (position.y == seats.lastIndex) return null
        return seats[position.y + 1][position.x]
    }

    internal fun getDownLeft(position: SeatPosition): Seat? {
        if (position.x == 0 || position.y == seats.lastIndex) return null
        return seats[position.y + 1][position.x - 1]
    }

    internal fun getLeft(position: SeatPosition): Seat? {
        if (position.x == 0) return null
        return seats[position.y][position.x - 1]
    }

    internal fun getUpLeft(position: SeatPosition): Seat? {
        if (position.x == 0 || position.y == 0) return null
        return seats[position.y - 1][position.x - 1]
    }
}

enum class SeatType(private val char: Char) {

    EMPTY('L'),
    FLOOR('.'),
    OCCUPIED('#');

    override fun toString() = "$char"

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

    var update : SeatUpdate? = null

    internal fun occupiedSeatsAround() = countOccupiedSeatsAround() > 0

    internal fun noOccupiedSeatsAround() = !occupiedSeatsAround()

    internal fun countOccupiedSeatsAround(): Int {
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

    internal fun checkUpdate() {
        when (this.type) {
            FLOOR -> doNothing()
            EMPTY -> if (noOccupiedSeatsAround()) {
                this.update = SeatUpdate(OCCUPIED)
            }
            OCCUPIED -> if (countOccupiedSeatsAround() >= 4) {
                this.update = SeatUpdate(EMPTY)
            }
        }
    }

    internal fun update() {
        update?.let {
            this.type = it.newType
        }
        update = null
    }

    internal fun needsUpdate() = update != null

    internal fun isOccupied() = this.type == OCCUPIED
    internal fun isEmpty() = this.type == EMPTY
    internal fun isFloor() = this.type == FLOOR

    override fun toString() = this.type.toString() + "$position"

    private fun doNothing() {}
}

data class SeatUpdate(val newType: SeatType)

internal data class SeatPosition(val x: Int, val y: Int) {
    override fun toString() = "(x=$x,y=$y)"
}