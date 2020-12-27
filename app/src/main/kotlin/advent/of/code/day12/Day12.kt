package advent.of.code.day12

import advent.of.code.toURL
import java.io.File
import kotlin.math.max

class Day12 {

    companion object {

        @JvmStatic
        internal fun part1(): Int {
            val instructions = File("day12/input-day12.txt".toURL()).readLines().toInstructions()
            println("instructions: $instructions")
            val ship = Ship(instructions)
            ship.drive()
            return max(ship.position.east, ship.position.west) + max(ship.position.north, ship.position.south)
        }

        @JvmStatic
        internal fun part2(): Int {
            val instructions = File("day12/input-day12.txt".toURL()).readLines().toInstructions()
            println("instructions: $instructions")
            val ship = Ship(instructions)
            ship.drive()
            return max(ship.position.east, ship.position.west) + max(ship.position.north, ship.position.south)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("part1: ${part1()}")
            //println("part2: ${part2()}")
        }
    }
}


