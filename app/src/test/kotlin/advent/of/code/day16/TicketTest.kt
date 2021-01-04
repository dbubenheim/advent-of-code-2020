package advent.of.code.day16

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class TicketTest {

    @ParameterizedTest
    @MethodSource("dataForTestIsValid")
    fun testIsValid(rules: List<Rule>, tickets: Ticket, isValid: Boolean) {
        assertThat(tickets.isValid(rules)).isEqualTo(isValid)
    }

    @ParameterizedTest
    @MethodSource("dataForTestIsValid")
    fun testIsNotValid(rules: List<Rule>, tickets: Ticket, isValid: Boolean) {
        assertThat(tickets.isNotValid(rules)).isEqualTo(!isValid)
    }

    @ParameterizedTest
    @MethodSource("dataForTestErrorRate")
    fun testErrorRate(rules: List<Rule>, tickets: List<Ticket>, errorRate: Int) {
        val actualErrorRate = tickets.map { it.errorRate(rules) }.sum()
        assertThat(actualErrorRate).isEqualTo(errorRate)
    }

    @ParameterizedTest
    @MethodSource("dataForTestDepartureProduct")
    fun testDepartureProduct(ticket: Ticket, departureProduct: Long) {
        assertThat(ticket.departureProduct()).isEqualTo(departureProduct)
    }

    companion object {

        @JvmStatic
        fun dataForTestIsValid(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    "7,3,47".toNearbyTicket(),
                    true
                ),
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    "40,4,50".toNearbyTicket(),
                    false
                ),
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    "55,2,20".toNearbyTicket(),
                    false
                ),
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    "38,6,12".toNearbyTicket(),
                    false
                )

            )
        }

        @JvmStatic
        fun dataForTestErrorRate(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    listOf(
                        "7,3,47".toNearbyTicket(),
                        "40,4,50".toNearbyTicket(),
                        "55,2,20".toNearbyTicket(),
                        "38,6,12".toNearbyTicket()
                    ),
                    71
                ),
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    listOf(
                        "7,3,47".toNearbyTicket(),
                    ),
                    0
                ),
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    listOf(
                        "40,4,50".toNearbyTicket(),
                    ),
                    4
                ),
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    listOf(
                        "55,2,20".toNearbyTicket(),
                    ),
                    55
                ),
                Arguments.of(
                    listOf(
                        "class: 1-3 or 5-7".toRule(),
                        "row: 6-11 or 33-44".toRule(),
                        "seat: 13-40 or 45-50".toRule()
                    ),
                    listOf(
                        "38,6,12".toNearbyTicket()
                    ),
                    12
                )
            )
        }

        @JvmStatic
        fun dataForTestDepartureProduct(): Stream<Arguments> {

            return Stream.of(
                Arguments.of(
                    Ticket(
                        values = listOf(
                            FieldValue(field = Field(name = "class", position = 0), value = 151),
                            FieldValue(field = Field(name = "type", position = 1), value = 71),
                            FieldValue(field = Field(name = "route", position = 2), value = 67),
                            FieldValue(field = Field(name = "departure station", position = 3), value = 113),
                            FieldValue(field = Field(name = "arrival track", position = 4), value = 127),
                            FieldValue(field = Field(name = "train", position = 5), value = 163),
                            FieldValue(field = Field(name = "departure date", position = 6), value = 131),
                            FieldValue(field = Field(name = "price", position = 7), value = 59),
                            FieldValue(field = Field(name = "arrival location", position = 8), value = 137),
                            FieldValue(field = Field(name = "row", position = 9), value = 103),
                            FieldValue(field = Field(name = "duration", position = 10), value = 73),
                            FieldValue(field = Field(name = "arrival platform", position = 11), value = 139),
                            FieldValue(field = Field(name = "zone", position = 12), value = 107),
                            FieldValue(field = Field(name = "departure platform", position = 13), value = 101),
                            FieldValue(field = Field(name = "departure location", position = 14), value = 97),
                            FieldValue(field = Field(name = "departure track", position = 15), value = 149),
                            FieldValue(field = Field(name = "arrival station", position = 16), value = 157),
                            FieldValue(field = Field(name = "seat", position = 17), value = 53),
                            FieldValue(field = Field(name = "departure time", position = 18), value = 109),
                            FieldValue(field = Field(name = "wagon", position = 19), value = 61)
                        )
                    ),
                    2355350878831
                )
            )
        }
    }
}