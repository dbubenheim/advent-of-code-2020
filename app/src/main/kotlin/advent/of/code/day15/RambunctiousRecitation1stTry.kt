package advent.of.code.day15

internal class RambunctiousRecitation1stTry(val input: List<Long>) {

    fun spokenNumber(number: Long = 2020): Long {

        var start = System.nanoTime()
        val spokenNumbers = mutableListOf<Long>()
        var spokenNumber = 1L
        for (turn in 1..number) {

            if (turn % 1000L == 1L) {
                start = System.nanoTime()
            }

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

            if (spokenNumbers.size % 1000 == 0) {
                val end = System.nanoTime()
                println("turn $turn: $spokenNumber \t- time (${(end - start) / 1000000000.0})s")
                //println("turn $turn: $spokenNumber")
            }
        }
        return spokenNumber
    }
}