package advent.of.code

import advent.of.code.Day08.*
import java.io.File

class Day08 {
    
    companion object {

        @JvmStatic
        fun handheldHaltingPart2(): Int {
            var accumulator = 0
            val instructions = File("day08/input-day08.txt".toURL()).readLines().map { it.toInstruction() }
            val visited = mutableSetOf<Int>()
            val switchedInstructions = mutableSetOf<Int>()
            var index = 0
            var switched = false
            loop@while (index < instructions.size) {

                if (visited(visited, index)) {
                    index = 0
                    visited.clear()
                    switched = false
                    accumulator = 0
                    continue@loop
                }

                visited.add(index)
                val instruction = instructions[index]
                when (instruction.operation) {
                    Operation.JMP -> {
                        if (canSwitch(switched, switchedInstructions, index)) {
                            index += instruction.argument
                            continue@loop
                        }
                        switched = true
                        switchedInstructions.add(index)
                    }
                    Operation.ACC -> {
                        accumulator += instruction.argument
                    }
                    Operation.NOP -> {
                        if (canSwitch(switched, switchedInstructions, index, visited, instruction)) {
                            switched = true
                            switchedInstructions.add(index)
                            index += instruction.argument
                            continue@loop
                        }
                    }
                }
                index++
            }
            return accumulator.also { println("accumulator: $it") }
        }

        @JvmStatic
        fun handheldHaltingPart1(): Int {
            var accumulator = 0
            val instructions = File("day08/input-day08.txt".toURL()).readLines().map { it.toInstruction() }
            val visited = mutableSetOf<Int>()
            var index = 0
            loop@while (index < instructions.size) {
                if (switched(visited, index)) return accumulator
                visited.add(index)
                val instruction = instructions[index]
                when (instruction.operation) {
                    Operation.JMP -> {
                        index += instruction.argument
                        continue@loop
                    }
                    Operation.ACC -> {
                        accumulator += instruction.argument
                    }
                    Operation.NOP -> {
                    }
                }
                index++
            }
            return accumulator.also { println("accumulator: $it") }
        }

        private fun switched(switchedInstructions: Set<Int>, index: Int) =
                switchedInstructions.contains(index)

        private fun visited(visited: Set<Int>, index: Int) =
                visited.contains(index)

        private fun visited(visited: Set<Int>, index: Int, instruction: Instruction) =
                switched(visited, index + instruction.argument)

        private fun canSwitch(switched: Boolean, switchedInstructions: Set<Int>, index: Int) =
                switched || switched(switchedInstructions, index)

        private fun canSwitch(switched: Boolean, switchedInstructions: Set<Int>, index: Int, visited: Set<Int>, instruction: Instruction) =
                !switched && !switched(switchedInstructions, index) && !visited(visited, index, instruction)

        @JvmStatic
        fun main(args: Array<String>) {
            //println(handheldHaltingPart1())
            println(handheldHaltingPart2())
        }
    }

    data class Instruction(val operation: Operation, val argument: Int)

    enum class Operation {
        ACC,
        JMP,
        NOP
    }
}

private fun String.toInstruction(): Instruction {
    val split = this.split(" ")
    return Instruction(Operation.valueOf(split[0].toUpperCase()), split[1].toInt())
}
