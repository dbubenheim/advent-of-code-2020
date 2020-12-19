package advent.of.code

import java.io.File

class Day01 {

    companion object {

        @JvmStatic
        fun reportRepairPart1(): Int {
            val lines = File("day01/input-day01.txt".toURL()).readLines()
            lines.forEach { line1 ->
                val i = line1.toInt()
                lines.forEach { line2 ->
                    val j = line2.toInt()
                    if (i + j == 2020) {
                        return  i * j
                    }
                }
            }
            return -1
        }

        @JvmStatic
        fun reportRepairPart2(): Int {
            val lines = File("day01/input-day01.txt".toURL()).readLines()
            lines.forEach { line1 ->
                val i = line1.toInt()
                lines.forEach { line2 ->
                    val j = line2.toInt()
                    lines.forEach { line3 ->
                        val k = line3.toInt()
                        if (i + j + k == 2020) return i * j * k
                    }
                }
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