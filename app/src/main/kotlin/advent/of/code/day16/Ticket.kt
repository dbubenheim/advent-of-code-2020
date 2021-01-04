package advent.of.code.day16

data class Ticket(val values: List<FieldValue>) {

    fun isValid(rules: List<Rule>) =
        values
            .filter { fieldValue ->
                val ranges = rules.flatMap { it.ranges }
                val isValid = ranges.any { range -> fieldValue.value in range }
                //if (!isValid) println("value $fieldValue is invalid!")
                isValid
            }
            .size == values.size


    fun isNotValid(rules: List<Rule>) = !isValid(rules)

    fun errorRate(rules: List<Rule>): Int {

        if (isValid(rules)) return 0

        return values
            .map { fieldValue ->
                val ranges = rules.flatMap { it.ranges }
                val isInvalid = ranges.none { range -> fieldValue.value in range }
                if (isInvalid) {
                    //println("value $fieldValue is invalid!")
                    fieldValue.value
                } else 0
            }
            .sum()
            .also { println("error rate: $it") }
    }

    fun departureProduct() =
        values.filter { fieldValue -> fieldValue.field.name.startsWith("departure") }
            .map { fieldValue -> fieldValue.value.toLong() }
            .reduce { sum, value -> sum * value }

    fun updateFieldPositions(fieldPositions: List<Pair<Field, Int>>) =
        values.forEachIndexed { index, fieldValue ->
            val fieldPosition = fieldPositions.first { fieldPosition -> fieldPosition.second == index }
            val fieldName = fieldPosition.first.name
            val position = fieldPosition.second
            fieldValue.field.update(fieldName, position)
        }
}