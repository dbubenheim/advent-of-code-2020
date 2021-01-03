package advent.of.code.day16

import advent.of.code.toURL
import java.io.File

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
                .toNearbyTickets()
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