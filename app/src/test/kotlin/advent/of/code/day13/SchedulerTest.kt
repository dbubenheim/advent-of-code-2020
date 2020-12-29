package advent.of.code.day13

import advent.of.code.day13.Scheduler.Companion.isTimestamp
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SchedulerTest {

    @ParameterizedTest
    @MethodSource("testIsTimestamp")
    fun testIsTimestamp(bus: Bus, timestamp: Long) {
        assertThat(isTimestamp(bus, timestamp)).isTrue()
    }

    @ParameterizedTest
    @MethodSource("testEstimate")
    fun testEstimate(input: String, timestamp: Long) {
        val scheduler = Scheduler(input)
        assertThat(scheduler.estimateDeparture()).isEqualTo(timestamp)
    }

    companion object {

        @JvmStatic
        fun testEstimate(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "3,7,11",
                    174
                ),
                Arguments.of(
                    "67,7,59,61",
                    754018
                ),
                Arguments.of(
                    "67,x,7,59,61",
                    779210
                ),
                Arguments.of(
                    "67,7,x,59,61",
                    1261476
                ),
                Arguments.of(
                    "1789,37,47,1889",
                    1202161486
                ),
                Arguments.of(
                    "13,x,x,41,x,x,x,x,x,x,x,x,x,641,x,x,x,x,x,x,x,x,x,x,x,19,x,x,x,x,17,x,x,x,x,x,x,x,x,x,x,x,29,x,661,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,23",
                    800177252346225
                )
            )
        }

        // 7,13,x,x,59,x,31,19 -> 1068781
        @JvmStatic
        fun testIsTimestamp(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Bus(7L, 0L),
                    1068781
                ),
                Arguments.of(
                    Bus(13L, 1L),
                    1068781
                ),
                Arguments.of(
                    Bus(59L, 4L),
                    1068781
                ),
                Arguments.of(
                    Bus(31L, 6L),
                    1068781
                ),
                Arguments.of(
                    Bus(19L, 7L),
                    1068781
                ),
                Arguments.of(
                    Bus(19L, 7L),
                    1068781
                ),
            )
        }
    }
}