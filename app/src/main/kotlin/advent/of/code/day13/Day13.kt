package advent.of.code.day13

import advent.of.code.toURL
import java.io.File

class Day13 {

    companion object {

        @JvmStatic
        internal fun part1(): Long {
            val input = File("day13/input-day13.txt".toURL()).readLines()
            val departure = input[0].toLong()
            val buses = input[1].split(',')
                .mapIndexedNotNull { index, id -> if (id != "x") Bus(id.toLong(), index.toLong()) else null }

            println("departure: $departure")
            println("buses: $buses")

            val bus = buses
                .map { bus -> Pair(bus.id, bus.waitTime(departure)) }
                .minByOrNull { it.second }!!

            val result = bus.first * bus.second
            println("result: $result")
            return result
        }

        @JvmStatic
        internal fun part2(): Long {
            val input = File("day13/input-day13.txt".toURL()).readLines().drop(1)

            val scheduler = Scheduler(input[0])
            println("scheduler: $scheduler")

            return scheduler.estimateDeparture()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("part1: ${part1()}")
            println("part2: ${part2()}")
        }
    }
}