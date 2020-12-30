package advent.of.code.day03

import advent.of.code.toURL
import java.io.File

class Day03 {

    companion object {

        @JvmStatic
        fun tobbogganTrajectoryPart1(right: Int = 3, down: Int = 1): Long {

            val input = File("day03/input-day03.txt".toURL()).readLines()
            val maxX = input[0].length - 1
            val maxY = input.size - 1
            var count = 0L
            var y = 0
            var x = 0
            do {

                x += right
                if (x > maxX) {
                    x %= maxX
                    x--
                }
                y += down
                val field = input[y][x]
                if (field == TREE) count++

            } while (y < maxY)

            return count
        }

        @JvmStatic
        fun tobbogganTrajectoryPart2(): Long {

            var sum = tobbogganTrajectoryPart1(1, 1)
            sum *= tobbogganTrajectoryPart1(3, 1)
            sum *= tobbogganTrajectoryPart1(5, 1)
            sum *= tobbogganTrajectoryPart1(7, 1)
            sum *= tobbogganTrajectoryPart1(1, 2)

            return sum
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(tobbogganTrajectoryPart1(1, 1))
            println(tobbogganTrajectoryPart1(3, 1))
            println(tobbogganTrajectoryPart1(5, 1))
            println(tobbogganTrajectoryPart1(7, 1))
            println(tobbogganTrajectoryPart1(1, 2))

            println("part1: ${tobbogganTrajectoryPart1()}")
            println("part2: ${tobbogganTrajectoryPart2()}")
        }

        private const val TREE = '#'
    }
}