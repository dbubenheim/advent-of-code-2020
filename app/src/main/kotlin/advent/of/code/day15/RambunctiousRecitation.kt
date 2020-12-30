package advent.of.code.day15

internal class RambunctiousRecitation(val input: List<Long>) {

    // 1 -> [3, 8, 9]
    private val history = mutableMapOf<Long, LinkedHashSet<Long>>()
    private val history2 = mutableMapOf<Long, LongArray>()

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

    fun spokenNumber2(number: Long = 2020): Long {

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
                history.getValue(spokenNumber).size == 1 -> {
                //numberCounter.getValue(spokenNumber) == 1L -> {
                    spokenNumber = 0
                }
                history.getValue(spokenNumber).size > 1L -> {
                //numberCounter.getValue(spokenNumber) > 1L -> {
                    //t1 = measureNanoTime {
                        val turns = history.getValue(spokenNumber)
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

    fun spokenNumber3(number: Long = 2020): Long {

        //var start = System.nanoTime()
        //var t1 :Long? = null
        //var t2 :Long?
        //var t3 :Long?
        var spokenNumber = 1L
        for (turn in 1L..number) {

//            if (turn % 1000L == 1L) {
//                start = System.nanoTime()
//            }

            when {
                turn - 1 < input.size -> {
                    spokenNumber = input[turn.toInt() - 1]
                }
                turns(spokenNumber) == 1 -> {
                    spokenNumber = 0
                }
                turns(spokenNumber) > 1L -> {
                    //t1 = measureNanoTime {
                    val turns = history2.getValue(spokenNumber)
                    val lastIndex = turns[1]
                    val secondLastIndex = turns[0]
                    val diff = lastIndex - secondLastIndex
                    spokenNumber =  if (diff > 0) diff else 1 //max(diff, 1)
                    //}
                }
            }

            //t3 = measureNanoTime {
            update2(spokenNumber, turn)
            //}

//            if (turn % 1000L == 0L) {
//                val end = System.nanoTime()
//                println("turn $turn: $spokenNumber \t- time (${(end - start) / 1000000000.0})s")
//
//                //println("(t1: $t1 ns)")
//                //println("(t2: $t2 ns)")
//                //println("(t3: ($$t3 ns)")
//            }
        }
        return spokenNumber
    }

    private fun update(spokenNumber: Long, turn: Long) {
        history.putIfAbsent(spokenNumber, linkedSetOf())
        history[spokenNumber]?.add(turn)
    }

    private fun update2(spokenNumber: Long, turn: Long) {
        history2.putIfAbsent(spokenNumber, LongArray(2) { -1 })
        val turns = history2[spokenNumber]
        turns?.set(0, turns[1])
        turns?.set(1, turn)
    }

    private fun turns(spokenNumber: Long) : Int {
        val turns = history2.getValue(spokenNumber)
        var count = 0
        if (turns[0] != -1L) count++
        if (turns[1] != -1L) count++
        return count
    }

    companion object {
        @JvmStatic
        fun increment(map: MutableMap<Long, Long>, key: Long) {
            val count = map.getOrDefault(key, 0L)
            map[key] = count + 1L
        }
    }
}
