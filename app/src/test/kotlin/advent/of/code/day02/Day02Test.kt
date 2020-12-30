package advent.of.code.day02

import advent.of.code.day02.Day02.Companion.passwordPolicyPart1
import advent.of.code.day02.Day02.Companion.passwordPolicyPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day02Test {

    @Test
    fun testPart1() {
        assertThat(passwordPolicyPart1()).isEqualTo(591)
    }

    @Test
    fun testPart2() {
        assertThat(passwordPolicyPart2()).isEqualTo(335)
    }
}