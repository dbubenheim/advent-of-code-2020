package advent.of.code.day09

import advent.of.code.day09.Day09.Companion.part1
import advent.of.code.day09.Day09.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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