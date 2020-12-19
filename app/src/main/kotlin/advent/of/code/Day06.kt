package advent.of.code

import java.io.File

internal class Day06 {

    companion object {

        @JvmStatic
        fun customCustomsPart1() : Int {
            val m = mutableMapOf<Int, Set<Char>>()
            var questions = mutableSetOf<Char>()
            var group = 1
            File("day06/input-day06.txt".toURL()).forEachLine { line ->
                if (line.isBlank()) {
                    m[group] = questions
                    questions = mutableSetOf()
                    group++
                } else {
                    questions.addAll(line.toCharArray().toList())
                }
            }
            m[group] = questions
            println(m)
            return m.values.sumBy { it.size }
        }

        @JvmStatic
        fun customCustomsPart2() : Int {
            val m = mutableMapOf<Int, Set<Char>>()
            var questions = mutableSetOf<Char>()
            var people = 0
            var group = 1
            File("day06/input-day06.txt".toURL()).forEachLine { line ->
                if (line.isBlank()) {
                    m[group] = questions
                    questions = mutableSetOf()
                    people = 0
                    group++
                } else {
                    val curQuestions = line.toCharArray().toList()
                    if (people == 0) {
                        questions.addAll(curQuestions)
                    } else {
                        questions.removeIf { it !in curQuestions }
                    }
                    people++
                }
            }
            m[group] = questions
            println(m)
            return m.values.sumBy { it.size }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val sumPart1 = customCustomsPart1()
            println("sumPart1: $sumPart1")

            val sumPart2 = customCustomsPart2()
            println("sumPart2: $sumPart2")
        }
    }
}