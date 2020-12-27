package advent.of.code.day12

internal fun List<String>.toInstructions(): List<Instruction> = this.map { it.toInstruction() }
internal fun String.toInstruction() = Instruction(Action.of(this[0]), Units.of(this.substring(1)))