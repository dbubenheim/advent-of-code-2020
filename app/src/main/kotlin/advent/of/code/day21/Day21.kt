package advent.of.code.day21

import advent.of.code.day19.Day19
import advent.of.code.toURL
import java.io.File

class Day21 {

    companion object {

        @JvmStatic
        fun part1() {

            val input = File("day21/input-day21.txt".toURL()).readLines()
            println("input: $input")

            val rules = input.map { it.split(" ") }
            println("rules: $rules")
        }

        @JvmStatic
        fun main(args: Array<String>) {
            part1()
        }
    }
}