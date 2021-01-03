package advent.of.code.day16

data class Ticket(val values: List<Int>) {

    fun isValid(rules: List<Rule>): Boolean {
        val validFields = values.filterIndexed { index, fieldValue ->
            val ranges: List<IntRange> = rules[index].ranges
            ranges.any { range -> fieldValue in range }//.also { if (!it) println(it) }
        }
            .size
        return validFields == values.size
    }

    fun isNotValid(rules: List<Rule>) = !isValid(rules)

    fun errorRate(rules: List<Rule>) : Int {

        if (isValid(rules)) return 0

        return values.mapIndexed { index, fieldValue ->
            val ranges: List<IntRange> = rules[index].ranges
            if (ranges.none { range -> fieldValue in range }) fieldValue else 0
        }
        .sum()
    }
}