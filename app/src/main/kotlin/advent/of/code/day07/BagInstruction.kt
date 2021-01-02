package advent.of.code.day07

data class BagInstruction(val bag: Bag) {

    fun bagContains(instructions: Map<String, BagInstruction>, bagToSearchFor: String): Boolean {
        var result = false
        if (bag.contains(bagToSearchFor)) return true
        else {
            bag.children.forEach { childBag ->
                val childBagInstruction = instructions[childBag.name]
                childBagInstruction?.let {
                    if (childBagInstruction.bagContains(instructions, bagToSearchFor)) result = true
                }
            }
        }
        return result
    }
}