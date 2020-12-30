package advent.of.code.day15

internal class RambunctiousRecitation2ndTry(val input: List<Long>) {

    // 1 -> [3, 8, 9]
    private val lastTurns = mutableMapOf<Long, LinkedHashSet<Long>>()

    fun spokenNumber(number: Long = 2020): Long {

        var start = System.nanoTime()
        //var t1 :Long? = null
        //var t2 :Long?
        //var t3 :Long?
        //val numberCounter = mutableMapOf<Long, Long>()
        var spokenNumber = 1L
        for (turn in 1L..number) {

            if (turn % 1000L == 1L) {
                start = System.nanoTime()
            }

            when {
                turn - 1 < input.size -> {
                    spokenNumber = input[turn.toInt() - 1]
                }
                lastTurns.getValue(spokenNumber).size == 1 -> {
                    //numberCounter.getValue(spokenNumber) == 1L -> {
                    spokenNumber = 0
                }
                lastTurns.getValue(spokenNumber).size > 1L -> {
                    //numberCounter.getValue(spokenNumber) > 1L -> {
                    //t1 = measureNanoTime {
                    val turns = lastTurns.getValue(spokenNumber)
                    val lastIndex = turns.elementAt(turns.size - 1)
                    val secondLastIndex = turns.elementAt(turns.size - 2)
                    val diff = lastIndex - secondLastIndex
                    spokenNumber =  if (diff > 0) diff else 1 //max(diff, 1)
                    //}
                }
            }

//            t2 = measureNanoTime {
//                increment(numberCounter, spokenNumber)
//            }

            //t3 = measureNanoTime {
            update(spokenNumber, turn)
            //}

            if (turn % 1000L == 0L) {
                val end = System.nanoTime()
                println("turn $turn: $spokenNumber \t- time (${(end - start) / 1000000000.0})s")

                //println("(t1: $t1 ns)")
                //println("(t2: $t2 ns)")
                //println("(t3: ($$t3 ns)")
            }
        }
        return spokenNumber
    }

    private fun update(spokenNumber: Long, turn: Long) {
        lastTurns.putIfAbsent(spokenNumber, linkedSetOf())
        lastTurns[spokenNumber]?.add(turn)
    }

    companion object {
        @JvmStatic
        fun increment(map: MutableMap<Long, Long>, key: Long) {
            val count = map.getOrDefault(key, 0L)
            map[key] = count + 1L
        }
    }
}