package advent.of.code.day01

import advent.of.code.toURL
import java.io.File

class Day01 {

    companion object {

        @JvmStatic
        fun reportRepairPart1(): Int {
            val values = File("day01/input-day01.txt".toURL()).readLines().map { it.toInt() }
            val storage = mutableSetOf<Int>()
            var counter = 0
            values.forEach { value ->
                val diff = 2020 - value
                if (storage.contains(diff)) {
                    println("counter: $counter")
                    return value * diff
                }
                storage.add(value)
                counter++
            }
            return -1
        }

        @JvmStatic
        fun reportRepairPart2(): Int {
            val values = File("day01/input-day01.txt".toURL()).readLines().map { it.toInt() }
            val memory = mutableSetOf<Int>()
            var counter = 0
            values.forEach { value1 ->
                values.forEach { value2 ->
                    val diff = 2020 - value1 - value2
                    if (memory.contains(diff)) {
                        println("counter: $counter")
                        return value1 * value2 * diff
                    }
                    memory.add(value2)
                    counter++
                }
                counter++
            }
            return -1
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(reportRepairPart1())
            println(reportRepairPart2())
        }
    }
}