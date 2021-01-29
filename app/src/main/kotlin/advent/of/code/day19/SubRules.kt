package advent.of.code.day19

data class SubRules(val rules : Set<RuleSet>) : HashSet<RuleSet>() {

    companion object {
        val EMPTY = SubRules(emptySet())
    }
}