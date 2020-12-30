package advent.of.code.day03

import advent.of.code.day03.Day03.Companion.tobbogganTrajectoryPart1
import advent.of.code.day03.Day03.Companion.tobbogganTrajectoryPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day03Test {

    @Test
    fun testPart1() {
        assertThat(tobbogganTrajectoryPart1()).isEqualTo(234)
    }

    @Test
    fun testPart2() {
        assertThat(tobbogganTrajectoryPart2()).isEqualTo(5813773056)
    }
}