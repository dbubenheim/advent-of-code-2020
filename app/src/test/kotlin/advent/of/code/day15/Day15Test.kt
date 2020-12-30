package advent.of.code.day15

import advent.of.code.day15.Day15.Companion.part1
import advent.of.code.day15.Day15.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day15Test {

    @Test
    fun testPart1() {
        assertThat(part1()).isEqualTo(536)
    }

    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(24065124)
    }
}
