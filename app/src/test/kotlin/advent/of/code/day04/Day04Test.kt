package advent.of.code.day04

import advent.of.code.day03.Day03
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day04Test {

    @Test
    fun testPart1() {
        assertThat(Day03.tobbogganTrajectoryPart1()).isEqualTo(234)
    }

    @Test
    fun testPart2() {
        assertThat(Day03.tobbogganTrajectoryPart2()).isEqualTo(5813773056)
    }
}