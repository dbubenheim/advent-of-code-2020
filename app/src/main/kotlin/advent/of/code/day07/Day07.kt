package advent.of.code.day07

import advent.of.code.toURL
import java.io.File

internal class Day07 {

    companion object {

        @JvmStatic
        fun part1(): Int {

            // posh brown bag=[(5, dim coral bag), (1, plaid blue bag), (2, faded bronze bag), (2, light black bag)]
            val instructions = parseInstructions()
            return instructions.filter { bag -> bagContains(bag.value, instructions) }.size

            // for (i in instructions) {
            //    val name = it.key
            //    for (pair in it.values) {
            //       val childName = pair.first
            //       val childBags = instructions[childName]
            //
            // }


            // Bag(name=light red bag, contains=[ (1, Bag(bright white bag, contains=[]) ],

//            val bags: Map<String, Bag> = lines
//                .map { it.split(" contain ").toBag() }
//                .associateBy { it.name }

//            println("bags: $bags")
//
//            val bag = "shiny gold bag"
//            return bags.filter {
//                it.value.contains(bag)
//                        || it.value.children.any { child -> bags[child.first]!!.contains(bag) }
//            }
//            .map { it.key }
//            .also { println("bag: $it") }
//            .size

            // return count
        }

        private fun parseInstructions(): Map<String, Set<Pair<Int, String>>> {
            val instructions = File("day07/input-day07.txt".toURL())
                .readLines()
                .map { instruction ->
                    val splitInstruction = instruction.split(" contain ")
                    val bagName = splitInstruction[0].removeSuffix("s")
                    val contains = splitInstruction[1]
                        .split(',')
                        .filter { !it.startsWith("no") }
                        .mapNotNull { bag ->
                            bag.removeSuffix(".")
                            val match = Regex("(\\d+) ([\\w|\\s]+)").find(bag)
                            if (match != null) {
                                val (amount, name) = match.destructured
                                val finalName = if (amount.toInt() > 1) name.removeSuffix("s") else name
                                Pair(amount.toInt(), finalName)
                            } else {
                                null
                            }
                        }
                        .toSet()
                    bagName to contains
                }
                .toMap()

            println("instructions: $instructions")
            return instructions
        }

        private fun bagContains(
            bags: Set<Pair<Int, String>>,
            instructions: Map<String, Set<Pair<Int, String>>>,
            bagToSearchFor: String = "shiny gold bag"
        ): Boolean {

            var result = false
            if (bags.any { it.second == bagToSearchFor }) return true
            else {
                bags.forEach { childBag ->
                    val childBagName = childBag.second
                    val childBags = instructions[childBagName]
                    childBags?.let {
                        if (bagContains(childBags, instructions)) result = true
                    }
                }
            }
            return result
        }

        @JvmStatic
        fun part2(): Int {
            TODO("Implement part2")
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("${part1()}")
            //println("${part2)}")
        }
    }
}