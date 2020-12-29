package advent.of.code.day13

data class Scheduler(val buses: Sequence<Bus>) {

    constructor(input: String) : this(
        input.split(',')
            .mapIndexedNotNull { index, id -> if (id != "x") Bus(id.toLong(), index.toLong()) else null }
            .asSequence()
    )

    fun estimateDeparture(): Long {
        println("estimating departure")

        var timestamp = 1L
        var step = 1L

        for (bus in buses) {
            while (!isTimestamp(bus, timestamp)) {
                timestamp += step
            }
            step *= bus.id
        }

        return timestamp
    }

    override fun toString() = "Scheduler(buses=${buses.toList()})"

    companion object {

        @JvmStatic
        internal fun isTimestamp(bus: Bus, timestamp: Long) =
            (timestamp + bus.index) % bus.id == 0L
    }
}