package advent.of.code.day19

import advent.of.code.toURL
import java.io.File

class Day19 {

    companion object {

        @JvmStatic
        fun part1(): Int {

            val input = File("day19/input-day19-1.txt".toURL()).readLines()
            println("input: $input")

            val rules = rules(input)
            println("rules: $rules")

            val texts = texts(input)
            println("texts: $texts")

            return texts.count { it.matches(rules) }
        }

        private fun rules(lines: List<String>) =
            lines.takeWhile { it.isNotBlank() }.toRules()

        private fun texts(lines: List<String>): List<String> {
            val start = lines.indexOfFirst { it.isBlank() } + 1
            return lines.subList(start, lines.lastIndex)
        }

        @JvmStatic
        fun part2() : Int {
            val input = File("day19/input-day19.txt".toURL()).readLines()
            println("input: $input")

            return -1
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(part1())
            println(part2())
        }
    }
}

private fun String.matches(rules: List<Rule>): Boolean {
    return false
}
