package advent.of.code.day11

import advent.of.code.toURL
import java.io.File

internal class Day11 {

    companion object {

        @JvmStatic
        internal fun part1(): Int {
            val seatLayoutPart1 = File("day11/input-day11.txt".toURL()).readLines().toSeatLayoutPart1()
            return seatLayoutPart1.predict()
        }

        @JvmStatic
        internal fun part2(): Int {
            val seatLayoutPart2 = File("day11/input-day11.txt".toURL()).readLines().toSeatLayoutPart2()
            return seatLayoutPart2.predict()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("part1: ${part1()}")
            println("part2: ${part2()}")
        }
    }
}