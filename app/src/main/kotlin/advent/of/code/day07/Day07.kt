package advent.of.code.day07

internal class Day07 {

    companion object {

        @JvmStatic
        fun part1(): Int {
            val airport = InstructionParser.parseBagInstructions().toAirport()
            return airport.howManyBagsCanContainA("shiny gold bag")
        }

        @JvmStatic
        fun part2(): Int {
            val airport = InstructionParser.parseBagInstructions().toAirport()
            return airport.howManyBagsAreRequiredForA("shiny gold bag")
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("${part1()}")
            println("${part2()}")
        }
    }
}