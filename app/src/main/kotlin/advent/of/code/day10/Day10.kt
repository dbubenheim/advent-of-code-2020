package advent.of.code.day10

import advent.of.code.toURL
import java.io.File

internal class Day10 {

    companion object {

        @JvmStatic
        fun part1(): Long {
            val adapters = File("day10/input-day10.txt".toURL()).readLines().map { it.toLong() }.sorted()
            var ones = 0L
            var threes = 0L
            var last = 0L
            adapters.forEach { number ->
                when (number - last) {
                    1L -> ones++
                    3L -> threes++
                }
                last = number
            }
            return ones * ++threes
        }

        @JvmStatic
        fun part1Functional() = File("day10/input-day10.txt".toURL())
                .readLines()
                .map { it.toLong() }
                .sorted()
                .toMutableList()
                .apply { add(0, 0) }
                .apply { add(this.size, this.last() + 3) }
                .windowed(2, 1)
                .map { it[1] - it[0] }
                .groupBy { it }
                .values
                .map { it.size }
                .reduce { a, b -> a * b }

        @JvmStatic
        fun part2() : Long {
            return File("day10/input-day10.txt".toURL())
                .readLines()
                .map { it.toInt() }
                .sorted()
                .toMutableList()
                .apply { add(0, 0) }
                .apply { add(this.size, this.last() + 3) }
                .run {
                    computePaths(this)
                }
        }

        private fun computePaths(
            input: MutableList<Int>,
            index: Int = 0,
            memo: MutableMap<Int, Long> = mutableMapOf()
        ) : Long {

            if (index in memo) return memo.getValue(index)
            if (index == input.lastIndex) return 1

            var result = 0L

            (1..3).forEach {
                val newIndex = index + it
                if (newIndex <= input.lastIndex && input[newIndex] - input[index] <= 3) {
                    result += computePaths(input, newIndex, memo)
                }
            }

            memo[index] = result
            return result
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(part1())
            println(part1Functional())
            println(part2())
        }
    }
}