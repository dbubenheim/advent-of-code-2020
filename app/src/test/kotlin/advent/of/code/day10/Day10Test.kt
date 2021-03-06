package advent.of.code.day10

import advent.of.code.day10.Day10.Companion.part1
import advent.of.code.day10.Day10.Companion.part1Functional
import advent.of.code.day10.Day10.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day10Test {

    @Test
    fun testPart1() {
        assertThat(part1()).isEqualTo(2414)
    }

    @Test
    fun testPart1Functional() {
        assertThat(part1Functional()).isEqualTo(2414)
    }

    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(21156911906816)
    }
}