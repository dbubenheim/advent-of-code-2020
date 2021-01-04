package advent.of.code.day16

import advent.of.code.day16.Day16.Companion.part1
import advent.of.code.day16.Day16.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day16Test {

    @Test
    fun testPart1() {
        assertThat(part1()).isEqualTo(18227)
    }

    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(2355350878831)
    }
}
