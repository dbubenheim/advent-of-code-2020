package advent.of.code

import advent.of.code.Day01.Companion.reportRepairPart1
import advent.of.code.Day01.Companion.reportRepairPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class Day01Test {

    @Test
    fun testPart1() {
        assertThat(reportRepairPart1()).isEqualTo(32064)
    }

    @Test
    fun testPart2() {
        assertThat(reportRepairPart2()).isEqualTo(193598720)
    }
}