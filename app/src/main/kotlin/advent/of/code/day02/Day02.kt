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
            fun passwordPolicyPart1(): Int {
                    return File("day02/input-day02.txt".toURL()).readLines().filter { line ->
                            val split = line.split(" ")
                            val amount = split[0]
                            val character = split[1][0]
                            val password = split[2]
                            val count = password.count { it == character }
                            count in amount.asRange()
                    }.size
            }

            @JvmStatic
            fun passwordPolicyPart2(): Int {
                    return File("day02/input-day02.txt".toURL()).readLines().filter { line ->
                            val split = line.split(" ")
                            val positions = split[0].split("-")
                            val character = split[1][0]
                            val password = split[2]
                            (password[positions[0].toInt() - 1] == character) xor (password[positions[1].toInt() - 1] == character)
                    }.size
            }
    }
}

private fun String.asRange(): IntRange {
    val split = this.split("-")
    return IntRange(split[0].toInt(), split[1].toInt())
}

