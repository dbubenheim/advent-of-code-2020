package advent.of.code.day07

fun List<String>.toBag(): Bag {

    val name = this[0].removeSuffix("s")

    val contains = this[1]
        .split(',')
        .filter { !it.startsWith("no") }
        .mapNotNull { bag ->
            bag.removeSuffix(".")
            val match = Regex("(\\d+) ([\\w|\\s]+)").find(bag)
            if (match != null) {
                val (amount, name) = match.destructured
                val finalName = if (amount.toInt() > 1) name.removeSuffix("s") else name
                ChildBag(amount.toInt(), Bag(finalName, emptySet()))
            } else {
                null
            }
        }
        .toSet()

    return Bag(name, contains)
}
