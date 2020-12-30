package advent.of.code.day15

import advent.of.code.toURL
import java.io.File

internal class Day15 {

    companion object {

        @JvmStatic
        fun part1(): Long {
            val input = File("day15/input-day15.txt".toURL()).readLines()[0].split(',').map { it.toLong() }
            println("input: $input")
            val rambunctiousRecitation = RambunctiousRecitation(input)
            return rambunctiousRecitation.spokenNumber3()
        }

        @JvmStatic
        fun part2(): Long {
            val input = File("day15/input-day15.txt".toURL()).readLines()[0].split(',').map { it.toLong() }
            println("input: $input")
            val rambunctiousRecitation = RambunctiousRecitation(input)
            return rambunctiousRecitation.spokenNumber3(30000000)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("part1: ${part1()}")
            println("part2: ${part2()}")
        }
    }
}