package advent.of.code.day02

import advent.of.code.toURL
import java.io.File

class Day02 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(passwordPolicyPart1())
            println(passwordPolicyPart2())
        }

        @JvmStatic
        fun passwordPolicyPart1() =
            File("day02/input-day02.txt".toURL()).readLines().filter { line -> isPolicy1(line) }.size

        @JvmStatic
        fun passwordPolicyPart2() =
            File("day02/input-day02.txt".toURL()).readLines().filter { line -> isPolicy2(line) }.size

        private fun isPolicy2(line: String): Boolean {
            val split = line.split(" ")
            val positions = split[0].split("-")
            val character = split[1][0]
            val password = split[2]
            return (password[positions[0].toInt() - 1] == character) xor (password[positions[1].toInt() - 1] == character)
        }

        private fun isPolicy1(line: String): Boolean {
            val split = line.split(" ")
            val amount = split[0]
            val character = split[1][0]
            val password = split[2]
            val count = password.count { it == character }
            return count in amount.asRange()
        }

        private fun String.asRange(): IntRange {
            val split = this.split("-")
            return IntRange(split[0].toInt(), split[1].toInt())
        }
    }
}