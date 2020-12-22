package advent.of.code

import advent.of.code.Day09.Companion.part1
import advent.of.code.Day09.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class Day09Test {

    @Test
    fun testPart1() {
        assertThat(part1()).isEqualTo(675280050)
    }

    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(96081673)
    }
}