package advent.of.code.day07

data class Bag(val name: String, val children: Set<ChildBag>) {
    fun contains(bag: String) = children.any { it.name == bag }
    fun sumOfChildren(bagInstructions: Map<String, BagInstruction>): Int {
        var sum = 0
        sum += children.sumBy { it.amount }
        children.forEach { childBag ->
            sum += childBag.amount * (bagInstructions[childBag.name]?.bag?.sumOfChildren(bagInstructions) ?: 0)
        }
        return sum
    }
}

