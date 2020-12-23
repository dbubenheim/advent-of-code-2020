package advent.of.code

import advent.of.code.Day06.Companion.customCustomsPart1
import advent.of.code.Day06.Companion.customCustomsPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day06Test {

    @Test
    fun testPart1() {
        assertThat(customCustomsPart1()).isEqualTo(6583)
    }

    @Test
    fun testPart2() {
        assertThat(customCustomsPart2()).isEqualTo(3290)
    }
}