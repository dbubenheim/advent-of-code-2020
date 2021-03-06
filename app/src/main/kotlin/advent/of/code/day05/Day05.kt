package advent.of.code.day05

import advent.of.code.toURL
import java.io.File
import java.lang.Integer.max

class Day05 {

    companion object {

        @JvmStatic
        fun binaryBoardingPart1(): Int {
            var max = 0
            File("day05/input-day05.txt".toURL()).forEachLine { line ->
                val seatId = decodeBoardingPass(line)
                max = max(max, seatId)
            }
            return max
        }

        @JvmStatic
        fun binaryBoardingPart2(): Int {
            val m = mutableSetOf<Int>()
            File("day05/input-day05.txt".toURL()).forEachLine { line ->
                m.add(decodeBoardingPass(line))
            }
            val l = m.sorted()
            val minus = (l.first()..l.last()).minus(l)
            return minus.first()
        }

        @JvmStatic
        private fun decodeBoardingPass(input: String): Int {

            var rows = 0..127
            var seats = 0..7

            //var index = 0
            for (i in input) {
                if (i in "FB") {
                    rows = if (i == 'F')
                        rows.first until (rows.last - ((rows.last - rows.first) / 2))
                    else
                        (rows.first + ((rows.last - rows.first) / 2)) + 1..rows.last
                } else if (i in "RL") {
                    seats = if (i == 'L')
                        seats.first until (seats.last - ((seats.last - seats.first) / 2))
                    else
                        ((seats.first + ((seats.last - seats.first) / 2)) + 1)..seats.last
                }
                //println("${++index}. rows: $rows")
                //println("${index}. seats: $seats")
            }
            return rows.first * 8 + seats.first
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(binaryBoardingPart1())
            println(binaryBoardingPart2())
        }
    }
}