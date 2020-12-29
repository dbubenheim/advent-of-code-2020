package advent.of.code.day13

data class Bus(val id: Long, val index: Long) {

    fun waitTime(departure: Long): Long {
        var times = 1
        while (id * times < departure) times++
        return id * times - departure
    }
}