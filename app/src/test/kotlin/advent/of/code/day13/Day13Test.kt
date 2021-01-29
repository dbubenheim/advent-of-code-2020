package advent.of.code.day13

import advent.of.code.day13.Day13.Companion.part1
import advent.of.code.day13.Day13.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day13Test {

    @Test
    fun testPart1() {
        assertThat(part1()).isEqualTo(3966)
    }

    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(800177252346225)
    }
}