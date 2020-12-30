package advent.of.code.day09

import advent.of.code.toURL
import java.io.File

internal class Day09 {

    companion object {

        @JvmStatic
        fun part1(preamble: Int = 25): Long {
            val numbers = File("day09/input-day09.txt".toURL()).readLines().map { it.toLong() }
            (preamble..numbers.size).forEach { index ->
                val number = numbers[index]
                if (!isSum(number, numbers.subList(index - preamble, index)))
                    return number
            }
            return -1
        }

        @JvmStatic
        fun part2(number: Long = 675280050): Long {
            val numbers = File("day09/input-day09.txt".toURL()).readLines().map { it.toLong() }
            var index = 0
            var currentStart = index
            val contiguousNumbers = mutableSetOf<Long>()
            while (index < numbers.size) {
                contiguousNumbers.add(numbers[index])
                val sum = contiguousNumbers.sum()
                if (sum == number)
                    return ((contiguousNumbers.maxOrNull() ?: 0L) + (contiguousNumbers.minOrNull() ?: 0L))
                if (sum > number) {
                    contiguousNumbers.clear()
                    index = ++currentStart
                    continue
                }
                index++
            }
            return -1
        }

        private fun isSum(number: Long, subList: List<Long>): Boolean {
            subList.forEach { i ->
                subList.forEach { j ->
                    if (i + j == number) return true
                }
            }
            return false
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(part1())
            println(part2())
        }
    }
}