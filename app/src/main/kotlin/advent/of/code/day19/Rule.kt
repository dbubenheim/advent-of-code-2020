package advent.of.code.day19

data class Rule(val id: Int, val regex: Char? = null, val subRules: SubRules = SubRules.EMPTY)