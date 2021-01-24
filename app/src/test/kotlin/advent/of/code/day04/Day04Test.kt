package advent.of.code.day04

import advent.of.code.Day04.Companion.passportProcessing
import advent.of.code.ValidatorPart1
import advent.of.code.ValidatorPart2
import advent.of.code.day03.Day03
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