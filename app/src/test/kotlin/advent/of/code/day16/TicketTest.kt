package advent.of.code.day16

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class TicketTest {

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    fun testIsValid(rules: List<Rule>, tickets: List<Ticket>, isValid: Int) {

    }

    @ParameterizedTest
    @MethodSource("data")
    fun testErrorRate(rules: List<Rule>, tickets: List<Ticket>, errorRate: Int) {
        val actualErrorRate = tickets.map { it.errorRate(rules) }.sum()
        assertThat(actualErrorRate).isEqualTo(errorRate)
    }

    companion object {

        @JvmStatic
        fun data() : Stream<Arguments> {
            return Stream.of(
//                Arguments.of(
//                    listOf(
//                        "class: 1-3 or 5-7".toRule(),
//                        "row: 6-11 or 33-44".toRule(),
//                        "seat: 13-40 or 45-50".toRule()
//                    ),
//                    listOf(
//                        "7,3,47".toNearbyTicket(),
//                        "40,4,50".toNearbyTicket(),
//                        "55,2,20".toNearbyTicket(),
//                        "38,6,12".toNearbyTicket()
//                    ),
//                    71
//                ),
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