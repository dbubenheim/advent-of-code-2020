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
    fun testDepartureProduct(rules: List<Rule>, tickets: Ticket, departureProduct: Int) {
        assertThat(tickets.departureProduct()).isEqualTo(departureProduct)
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
    }
}