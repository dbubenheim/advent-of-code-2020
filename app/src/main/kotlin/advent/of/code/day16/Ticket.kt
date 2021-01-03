package advent.of.code.day16

data class Ticket(val values: List<Int>) {

    fun isValid(rules: List<Rule>): Boolean {
        val validFields = values.filter { fieldValue ->
            val ranges = rules.flatMap { it.ranges }
            val isValid = ranges.any { range -> fieldValue in range }
            if (!isValid) println("value $fieldValue is invalid!")
            isValid
        }
            .size
        return validFields == values.size
    }

    fun isNotValid(rules: List<Rule>) = !isValid(rules)

    fun errorRate(rules: List<Rule>) : Int {

        if (isValid(rules)) return 0

        return values.map { fieldValue ->
            val ranges = rules.flatMap { it.ranges }
            val isInvalid = ranges.none { range -> fieldValue in range }
            if (isInvalid) {
                println("value $fieldValue is invalid!")
                fieldValue
            } else 0
        }
        .sum()
        .also { println("error rate: $it") }
    }
}