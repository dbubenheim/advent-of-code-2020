package advent.of.code.day12

import kotlin.math.abs

class Position(var x: Int, var y: Int) {

    fun north(units: Int) {
        println("going north $units units")
        this.y += units
        println("new position: $this")
    }

    fun east(units: Int) {
        println("going east $units units")
        this.x += units
        println("new position: $this")
    }

    fun south(units: Int) {
        println("going south $units units")
        this.y -= units
        println("new position: $this")
    }

    fun west(units: Int) {
        println("going west $units units")
        this.x -= units
        println("new position: $this")
    }

    fun toManhattanDistance() = abs(x) + abs(y)

    override fun toString() = "($x,$y)"
}
