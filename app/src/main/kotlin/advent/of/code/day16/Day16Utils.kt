package advent.of.code.day16

import java.lang.IllegalArgumentException

internal fun List<String>.toNearbyTickets(): List<Ticket> {
    if (first().trim() != "nearby tickets:") throw IllegalArgumentException("tickets nearby are not parsable!")
    return drop(1)
        .map { line -> line.toNearbyTicket() }
}

internal fun String.toNearbyTicket(): Ticket {
    return toTicket()
}

internal fun String.toTicket() : Ticket {
    val values = split(',')
        .map { field -> FieldValue(Field(), field.toInt()) }
    return Ticket(values)
}

internal fun List<String>.toYourTicket(): Ticket {
    if (first().trim() != "your ticket:") throw IllegalArgumentException("your ticket not parsable!")
    return last().toTicket()
}

internal fun List<String>.toRules(): List<Rule> {
    return map { it.toRule() }
}

internal fun String.toRule(): Rule {
    val split = split(": ")
    val field = Field(split[0])
    val ranges = split[1].split(" or ")
    return Rule(field, ranges.map { it.toIntRange() })
}

internal fun String.toIntRange() : IntRange {
    val ranges = split("-")
    return ranges[0].toInt()..ranges[1].toInt()
}