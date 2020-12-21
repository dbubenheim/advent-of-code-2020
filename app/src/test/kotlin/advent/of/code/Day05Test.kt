package advent.of.code

import advent.of.code.Day05.Companion.binaryBoardingPart1
import advent.of.code.Day05.Companion.binaryBoardingPart2
import advent.of.code.Day06.Companion.customCustomsPart1
import advent.of.code.Day06.Companion.customCustomsPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

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