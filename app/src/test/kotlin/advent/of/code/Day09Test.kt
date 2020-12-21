package advent.of.code

import advent.of.code.Day08.Companion.handheldHaltingPart1
import advent.of.code.Day08.Companion.handheldHaltingPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class Day09Test {

    @Test
    fun testPart1() {
        assertThat(handheldHaltingPart1()).isEqualTo(1200)
    }

    @Test
    fun testPart2() {
        assertThat(handheldHaltingPart2()).isEqualTo(1023)
    }
}