package advent.of.code.day19

internal fun List<String>.toRules() = map { it.toRule() }.sortedBy { it.id.value }

internal fun String.toRule(): Rule {
    val parts = split(": ")
    val rules = parts[1]
    var regex : Char? = null
    var subRules = emptyList<RuleSet>()
    when {
        rules.contains("\"") -> regex = rules[1]
        rules.contains('|') -> subRules = rules.split(" | ").map { RuleSet(it.split(" ").map { id -> RuleId.from(id) }) }
        else -> subRules = listOf(RuleSet(rules.split(" ").map { id -> RuleId.from(id) }))
    }
    return Rule(RuleId.from(parts[0]), regex, subRules)
}