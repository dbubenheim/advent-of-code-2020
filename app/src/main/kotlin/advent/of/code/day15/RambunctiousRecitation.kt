package advent.of.code.day15

internal class RambunctiousRecitation(private val input: List<Long>) {

    private val lastTurns = mutableMapOf<Long, LongArray>()

    fun spokenNumber(number: Long = 2020): Long {

        var spokenNumber = 1L
        for (turn in 1L..number) {

            when {
                turn - 1 < input.size -> {
                    spokenNumber = input[turn.toInt() - 1]
                }
                turns(spokenNumber) == 1 -> {
                    spokenNumber = 0
                }
                turns(spokenNumber) > 1L -> {
                    val turns = lastTurns.getValue(spokenNumber)
                    val lastIndex = turns[1]
                    val secondLastIndex = turns[0]
                    val diff = lastIndex - secondLastIndex
                    spokenNumber =  if (diff > 0) diff else 1 //max(diff, 1)
                }
            }

            update2(spokenNumber, turn)
        }
        return spokenNumber
    }

    private fun update2(spokenNumber: Long, turn: Long) {
        lastTurns.putIfAbsent(spokenNumber, LongArray(2) { -1 })
        val turns = lastTurns[spokenNumber]
        turns?.set(0, turns[1])
        turns?.set(1, turn)
    }

    private fun turns(spokenNumber: Long) : Int {
        val turns = lastTurns.getValue(spokenNumber)
        var count = 0
        if (turns[0] != -1L) count++
        if (turns[1] != -1L) count++
        return count
    }
}
