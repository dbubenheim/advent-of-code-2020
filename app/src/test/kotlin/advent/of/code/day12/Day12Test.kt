package advent.of.code.day12

import advent.of.code.day12.Day12.Companion.part1
import advent.of.code.day12.Day12.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day12Test {

    @Test
    fun testPart1() {
       assertThat(part1()).isEqualTo(938)
    }

    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(54404)
    }
}