package advent.of.code.day08

import advent.of.code.day08.Day08.Companion.handheldHaltingPart1
import advent.of.code.day08.Day08.Companion.handheldHaltingPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day08Test {

    @Test
    fun testPart1() {
        assertThat(handheldHaltingPart1()).isEqualTo(1200)
    }

    @Test
    fun testPart2() {
        assertThat(handheldHaltingPart2()).isEqualTo(1023)
    }
}