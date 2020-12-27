package advent.of.code.day11

import advent.of.code.day11.Day11.Companion.part1
import advent.of.code.day11.Day11.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Day11Test {

    @Test
    fun testPart1() {
        assertThat(part1()).isEqualTo(2113)
    }

    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(1865)
    }
}
