package advent.of.code.day05

import advent.of.code.day05.Day05.Companion.binaryBoardingPart1
import advent.of.code.day05.Day05.Companion.binaryBoardingPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day05Test {

    @Test
    fun testPart1() {
        assertThat(binaryBoardingPart1()).isEqualTo(978)
    }

    @Test
    fun testPart2() {
        assertThat(binaryBoardingPart2()).isEqualTo(727)
    }
}