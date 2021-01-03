package advent.of.code.day16

import advent.of.code.toURL
import java.io.File
import java.lang.IllegalArgumentException

internal class Day16 {

    companion object {

        @JvmStatic
        fun part1(): Int {

            val rules = File("day16/input-day16.txt".toURL()).bufferedReader()
                .useLines { lines -> lines.takeWhile { it.isNotBlank() }.toList() }
                .toRules()
            println("rules: $rules")

            val yourTicket = File("day16/input-day16.txt".toURL()).bufferedReader()
                .useLines { lines ->
                    val toList = lines.toList()
                    val start = toList.indexOfFirst { it.isBlank() } + 1
                    val end = toList.indexOfLast { it.isBlank() } - 1
                    toList.slice(start..end)
                }
                .toYourTicket()
            println("your ticket: $yourTicket")

            val ticketsNearby = File("day16/input-day16.txt".toURL()).bufferedReader()
                .useLines { lines ->
                    val toList = lines.toList()
                    val start = toList.indexOfLast { it.isBlank() } + 1
                    toList.subList(start, toList.lastIndex)
                }
                .toTicketsNearby()
            println("tickets nearby: $ticketsNearby")

            val invalidTickets = ticketsNearby.filter { ticket ->
                ticket.isNotValid(rules)
            }
            println("invalid tickets: $invalidTickets")

            return invalidTickets.map { it.errorRate(rules) }.sum()


            //return yourTicket.errorRate(rules)
        }

        @JvmStatic
        fun part2(): Int {
            TODO("")
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("${part1()}")
            println("${part2()}")
        }
    }
}

private fun List<String>.toTicketsNearby(): List<Ticket> {
    if (this.first().trim() != "nearby tickets:") throw IllegalArgumentException("tickets nearby are not parseable!")
    return drop(1)
        .map { line ->
            line.split(',')
                .map { field -> field.toInt() }
        }
        .map { Ticket(it) }
}

private fun List<String>.toYourTicket(): Ticket {
    if (this.first().trim() != "your ticket:") throw IllegalArgumentException("your ticket not parseable!")
    val values = this.last().split(',')
    return Ticket(values.map { it.toInt() })
}

private fun List<String>.toRules(): List<Rule> {
    return this.map { it.toRule() }
}

private fun String.toRule(): Rule {
    val split = this.split(": ")
    val field = Field(split[0])
    val ranges = split[1].split(" or ")
    return Rule(field, ranges.map { it.toIntRange() })
}

private fun String.toIntRange() : IntRange {
    val ranges = this.split("-")
    return ranges[0].toInt()..ranges[1].toInt()
}