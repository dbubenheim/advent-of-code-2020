package advent.of.code.day19

import advent.of.code.day19.Day19.Companion.part1
import advent.of.code.day19.Day19.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Day19Test {

    @Test
    fun testPart1() {
        assertThat(part1()).isEqualTo(213)
    }

    @Disabled
    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(123)
    }

    @Test
    fun testRegex() {
        val regex = """^a((aa|bb)(ab|ba)|(ab|ba)(aa|bb))b$""".toRegex()
        assertThat(regex.matches("ababbb")).isTrue()
        assertThat(regex.matches("bababa")).isFalse()
        assertThat(regex.matches("abbbab")).isTrue()
        assertThat(regex.matches("aaabbb")).isFalse()
        assertThat(regex.matches("aaaabbb")).isFalse()
    }
}