package advent.of.code.day07

fun String.toInstruction(): BagInstruction {
    val bag = this.toBag()
    return BagInstruction(bag)
}

fun String.toBag(): Bag {
    val splitInstruction = this.split(" contain ")
    val bagName = splitInstruction[0].removeSuffix("s")
    val contains = splitInstruction[1].toChildBags()
    return Bag(bagName, contains)
}

fun String.toChildBags() = this
    .split(',')
    .filter { !it.startsWith("no") }
    .mapNotNull { bag ->
        bag.removeSuffix(".")
        val match = Regex("(\\d+) ([\\w|\\s]+)").find(bag)
        if (match != null) {
            val (amount, name) = match.destructured
            val finalName = if (amount.toInt() > 1) name.removeSuffix("s") else name
            ChildBag(amount.toInt(), finalName)
        } else {
            null
        }
    }
    .toSet()

fun Map<String, BagInstruction>.toAirport() = Airport(this)