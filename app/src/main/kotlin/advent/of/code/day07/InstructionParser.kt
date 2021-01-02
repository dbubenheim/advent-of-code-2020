package advent.of.code.day07

import advent.of.code.toURL
import java.io.File

internal object InstructionParser {

    // posh brown bag=[(5, dim coral bag), (1, plaid blue bag), (2, faded bronze bag), (2, light black bag)]
    fun parseBagInstructions(fileName: String = "day07/input-day07.txt"): Map<String, BagInstruction> {
        val instructions = File(fileName.toURL())
            .readLines()
            .map { instructionString -> instructionString.toInstruction() }
            .map { it.bag.name to it }
            .toMap()

        //println("instructions: $instructions")
        return instructions
    }
}