package advent.of.code.day16

import advent.of.code.toURL
import java.io.File

internal class Day16 {

    companion object {

        @JvmStatic
        fun part1(): Int {
            val lines = File("day16/input-day16.txt".toURL()).readLines()

            val rules = rules(lines)
            //println("rules: $rules")

            val yourTicket = yourTicket(lines)
            println("yourTicket: $yourTicket")

            val nearbyTickets = nearbyTickets(lines)
            //println("nearbyTickets: $nearbyTickets")

            val invalidTickets = nearbyTickets.filter { ticket ->
                ticket.isNotValid(rules)
            }
            println("invalid tickets: $invalidTickets")

            return invalidTickets.map { it.errorRate(rules) }.sum()
        }

        @JvmStatic
        fun part2(): Long {
            val lines = File("day16/input-day16.txt".toURL()).readLines()

            val rules = rules(lines)
            //println("rules: $rules")
            println("# fields: ${rules.map { it.field }.size}")

            val yourTicket = yourTicket(lines)
            //println("yourTicket: $yourTicket")

            val nearbyTickets = nearbyTickets(lines)
            //println("nearbyTickets: $nearbyTickets")

            val validTickets = nearbyTickets.filter { ticket ->
                ticket.isValid(rules)
            }
            //println("validTickets: $validTickets")

            // "field" -> [0, 4, 23] valid positions
            val fieldPositions = findAllValidFieldPositions(rules, validTickets)
            println("validPositions (all): $fieldPositions")

            // phase 1 - solve the obvious positions
            solveObviousFieldPositions(fieldPositions)
            println("validPositions (phase 1): $fieldPositions")

            // phase 2 - solve the more complex ones
            solveComplexFieldPositions(fieldPositions)
            println("validPositions (phase 2): $fieldPositions")

            yourTicket.updateFieldPositions(fieldPositions.map { Pair(it.key, it.value.first()) })
            println("yourTicket: $yourTicket")

            return yourTicket.departureProduct()
        }

        private fun solveComplexFieldPositions(fieldPositions: List<MutableMap.MutableEntry<Field, MutableSet<Int>>>) {
            if (fieldPositions.any { it.value.size > 1 }) {
                val unsolved = fieldPositions.flatMap { it.value }.toMutableSet()
                while (unsolved.isNotEmpty()) {
                    for (position in unsolved) {
                        //println("position: $position")
                        var count = 0
                        //if (position)
                        for (entry in fieldPositions) {
                            //if (entry.value.size == 1) continue
                            if (entry.value.contains(position)) count++
                        }
                        //println("count: $count")
                        if (count == 1) {
                            for (entry in fieldPositions) {
                                entry.value.removeIf { it != position }
                            }
                            unsolved.remove(position)
                        }
                    }
                }
            }
        }

        private fun solveObviousFieldPositions(fieldPositions: List<MutableMap.MutableEntry<Field, MutableSet<Int>>>) {
            val takenPositions = mutableSetOf<Int>()
            for (entry in fieldPositions) {
                entry.value.removeAll(takenPositions)
                if (entry.value.size == 1) {
                    takenPositions.add(entry.value.first())
                }
            }
        }

        private fun findAllValidFieldPositions(
            rules: List<Rule>,
            validTickets: List<Ticket>
        ): List<MutableMap.MutableEntry<Field, MutableSet<Int>>> {

            val validPositions = mutableMapOf<Field, MutableSet<Int>>()
            for (rule in rules) {
                val ranges = rule.ranges.flatten()
                val field = rule.field
                for (position in rules.indices) {
                    var allValid = true
                    for (ticket in validTickets) {
                        if (ticket.values[position].value !in ranges) {
                            allValid = false
                            break
                        }
                    }
                    if (allValid) {
                        validPositions.putIfAbsent(field, mutableSetOf())
                        validPositions.getValue(field).add(position)
                    }
                }
            }
            return validPositions.entries.sortedBy { it.value.size }
        }

        private fun nearbyTickets(lines: List<String>): List<Ticket> {
            val start = lines.indexOfLast { it.isBlank() } + 1
            return lines.subList(start, lines.lastIndex + 1).toNearbyTickets()
        }

        private fun rules(lines: List<String>) =
            lines.takeWhile { it.isNotBlank() }.toList().toRules()

        private fun yourTicket(lines: List<String>): Ticket {
            val start = lines.indexOfFirst { it.isBlank() } + 1
            val end = lines.indexOfLast { it.isBlank() } - 1
            return lines.slice(start..end).toYourTicket()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            //println("${part1()}")
            println("${part2()}")
        }
    }
}