package advent.of.code.day19

data class RuleId(val value: Int) {
    override fun toString() = "$value"
    companion object {
        fun from(value: String) = RuleId(value.toInt())
    }
}