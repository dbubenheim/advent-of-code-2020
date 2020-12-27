package advent.of.code.day12

import advent.of.code.toURL
import java.io.File

class Day12 {

    companion object {

        @JvmStatic
        internal fun part1(): Int {
            val instructions = File("day12/input-day12.txt".toURL()).readLines().toInstructions()
            println("instructions: $instructions")
            val ship = Ship(instructions)
            ship.drive()
            return ship.position.toManhattanDistance()
        }

        @JvmStatic
        internal fun part2(): Int {
            val instructions = File("day12/input-day12.txt".toURL()).readLines().toInstructions()
            println("instructions: $instructions")
            val ship = Ship(instructions)
            ship.drive()
            return ship.position.toManhattanDistance()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("part1: ${part1()}")
            //println("part2: ${part2()}")
        }
    }
}


