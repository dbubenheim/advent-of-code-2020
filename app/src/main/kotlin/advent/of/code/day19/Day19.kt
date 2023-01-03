package advent.of.code.day19

import advent.of.code.toURL
import java.io.File

internal class Day19 {

    companion object {

        @JvmStatic
        fun part1(): Int {

            val input = File("day19/input-day19.txt".toURL()).readLines()
            println("input: $input")

            val rules = rules(input)
            println("rules: $rules")

            val regex = regex(rules)
            println("regex: $regex")

            val texts = texts(input)
            println("texts: $texts")

            return texts.count { text -> regex.matches(text) }
        }

        @JvmStatic
        fun part2(): Int {
            val input = File("day19/input-day19-4.txt".toURL()).readLines()
            println("input: $input")

            val rules = rules(input)
            println("rules: $rules")

            val regex = regex(rules)
            println("regex: $regex")

            val texts = texts(input)
            println("texts: $texts")

            return texts.count { text -> regex.matches(text) }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(part1())
            println(part2())
        }

        private fun regex(rules: List<Rule>): Regex {
            val literal = StringBuilder()
            literal.append('^')
            ruleToRegex(rules.first(), literal, rules)
            literal.append('$')
            return literal.toString().toRegex()
        }

        private fun ruleToRegex(rule: Rule, literal: StringBuilder, input: List<Rule>) {
            when {
                rule.regex != null -> literal.append(rule.regex)
                rule.ruleSets.isNotEmpty() -> {
                    rule.ruleSets.forEachIndexed { index, ruleSet ->
                        val moreThanOne = rule.ruleSets.size > 1
                        if (moreThanOne && index == 0) literal.append('(')
                        ruleSet.rules.forEach { subRule ->
                            ruleToRegex(input[subRule.value], literal, input)
                        }
                        val isLast = index == rule.ruleSets.lastIndex
                        if (moreThanOne && !isLast) literal.append('|')
                        if (moreThanOne && isLast) literal.append(')')
                    }
                }
            }
        }

        private fun rules(lines: List<String>) =
            lines.takeWhile { it.isNotBlank() }.toRules()

        private fun texts(lines: List<String>): List<String> {
            val start = lines.indexOfFirst { it.isBlank() } + 1
            return lines.subList(start, lines.lastIndex)
        }
    }
}