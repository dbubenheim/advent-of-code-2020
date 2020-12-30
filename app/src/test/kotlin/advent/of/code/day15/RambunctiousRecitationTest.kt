package advent.of.code.day15

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RambunctiousRecitationTest {

    @ParameterizedTest
    @MethodSource("spokenNumber")
    fun testSpokenNumber(input: List<Long>, number: Long, spokenNumber: Long) {
        val rambunctiousRecitation = RambunctiousRecitation(input)
        val result = rambunctiousRecitation.spokenNumber3(number)
        assertThat(result).isEqualTo(spokenNumber)
    }

    companion object {

        @JvmStatic
        fun spokenNumber(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(0, 3, 6),
                    2020,
                    436L
                ),
                Arguments.of(
                    listOf(1, 3, 2),
                    2020,
                    1L
                ),
                Arguments.of(
                    listOf(2, 1, 3),
                    2020,
                    10L
                ),
                Arguments.of(
                    listOf(1, 2, 3),
                    2020,
                    27L
                ),
                Arguments.of(
                    listOf(2, 3, 1),
                    2020,
                    78L
                ),
                Arguments.of(
                    listOf(3, 2, 1),
                    2020,
                    438L
                ),
                Arguments.of(
                    listOf(3, 1, 2),
                    2020,
                    1836L
                ),
                Arguments.of(
                    listOf(0, 3, 6),
                    30000000,
                    175594L
                ),
                Arguments.of(
                    listOf(1, 3, 2),
                    30000000,
                    2578L
                ),
                Arguments.of(
                    listOf(2, 1, 3),
                    30000000,
                    3544142L
                ),
                Arguments.of(
                    listOf(1, 2, 3),
                    30000000,
                    261214L
                ),
                Arguments.of(
                    listOf(2, 3, 1),
                    30000000,
                    6895259L
                ),
                Arguments.of(
                    listOf(3, 2, 1),
                    30000000,
                    18L
                ),
                Arguments.of(
                    listOf(3, 1, 2),
                    30000000,
                    362L
                )
            )
        }
    }
}