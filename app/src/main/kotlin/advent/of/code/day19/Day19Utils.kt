package advent.of.code.day19

internal fun List<String>.toRules() = map { it.toRule() }.sortedBy { it.id.value }

internal fun String.toRule(): Rule {

    val split = split(": ")
    val s : String = split[1]
    var regex : Char? = null
    var subRules = emptyList<RuleSet>()
    when {
        s.contains('|') -> {
            subRules = s.split(" | ")
                .map { RuleSet(it.split(" ").map { id -> RuleId(id.toInt()) }) }
        }
        s.contains("\"") -> {
            regex = s[1]
        }
        else -> {
            subRules = listOf(RuleSet(s.split(" ").map { id -> RuleId(id.toInt()) }))
        }
    }

    val id = split[0].toInt()
    return Rule(RuleId(id), regex, subRules)
}