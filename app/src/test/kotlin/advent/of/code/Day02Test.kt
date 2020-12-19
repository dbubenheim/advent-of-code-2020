package advent.of.code

import advent.of.code.Day02.Companion.passwordPolicyPart1
import advent.of.code.Day02.Companion.passwordPolicyPart2
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

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