package advent.of.code.day19

internal fun List<String>.toRules() = map { it.toRule() }

internal fun String.toRule(): Rule {

    val split = split(": ")
    val s : String = split[1]
    var regex : Char? = null
    var subRules = SubRules.EMPTY
    when {
        s.contains('|') -> {
            val map = s.split(" | ")
                .map { RuleSet(it.split(" ").map { id -> Id(id.toInt()) }.toSet()) }
                .toSet()
            subRules = SubRules(map)
        }
        s.contains("\"") -> {
            regex = s[1]
        }
        else -> {
            SubRules(setOf(RuleSet(s.split(" ").map { id -> Id(id.toInt()) }.toSet())))
        }
    }

    val id = split[0].toInt()
    return Rule(id, regex, subRules)
}

internal fun String.toIntRange() : IntRange {
    val ranges = split("-")
    return ranges[0].toInt()..ranges[1].toInt()
}