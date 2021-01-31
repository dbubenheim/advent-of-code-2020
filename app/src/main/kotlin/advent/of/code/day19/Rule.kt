package advent.of.code.day19

data class Rule(val id: RuleId, val regex: Char? = null, val ruleSets: List<RuleSet> = emptyList())