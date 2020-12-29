package advent.of.code.day15

import java.util.*

internal class RambunctiousRecitation(val input: List<Long>) {

    fun spokenNumber(number: Long = 2020): Long {

        val spokenNumbers = mutableListOf<Long>()
        var spokenNumber = 1L
        for (turn in 1..number) {

            when {
                turn - 1 < input.size -> {
                    spokenNumber = input[turn.toInt() - 1]
                }
                spokenNumbers.count { it == spokenNumber } == 1 -> {
                    spokenNumber = 0
                }
                spokenNumbers.count { it == spokenNumber } > 1 -> {

                    val lastIndex = spokenNumbers.lastIndexOf(spokenNumber)
                    val secondLastIndex = spokenNumbers.subList(0, lastIndex).lastIndexOf(spokenNumber)
                    val diff = lastIndex - secondLastIndex
                    spokenNumber = if (diff > 0) diff.toLong() else 1
                }
            }

            spokenNumbers.add(spokenNumber)

            //println("turn $turn: $spokenNumber")
        }
        return spokenNumber
    }

    fun spokenNumber2(number: Long = 2020): Long {

        val spokenNumbers = LinkedList<Long>()//mutableListOf<Long>()
        var spokenNumber = 1L
        for (turn in 1L..number) {

            when {
                turn - 1 < input.size -> {
                    spokenNumber = input[turn.toInt() - 1]
                }
                spokenNumbers.count { it == spokenNumber } == 1 -> {
                    spokenNumber = 0
                }
                spokenNumbers.count { it == spokenNumber } > 1 -> {

                    val lastIndex = spokenNumbers.lastIndexOf(spokenNumber)
                    val secondLastIndex = spokenNumbers.subList(0, lastIndex).lastIndexOf(spokenNumber)
                    val diff = lastIndex - secondLastIndex
                    spokenNumber = if (diff > 0) diff.toLong() else 1
                }
            }

            spokenNumbers.add(spokenNumber)

            //println("turn $turn: $spokenNumber")
        }
        return spokenNumber
    }
}