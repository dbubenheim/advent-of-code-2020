package advent.of.code.day04

import advent.of.code.day04.Day04.Companion.passportProcessing
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day04Test {

    @Test
    fun testPart1() {
        assertThat(passportProcessing(::ValidatorPart1)).isEqualTo(202)
    }

    @Test
    fun testPart2() {
        assertThat(passportProcessing(::ValidatorPart2)).isEqualTo(137)
    }
}