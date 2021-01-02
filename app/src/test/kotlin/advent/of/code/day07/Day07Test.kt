package advent.of.code.day07

import advent.of.code.day07.Day07.Companion.part1
import advent.of.code.day07.Day07.Companion.part2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day07Test {

    @Test
    fun testPart1() {
        assertThat(part1()).isEqualTo(238)
    }

    @Test
    fun testPart2() {
        assertThat(part2()).isEqualTo(82930)
    }

    @ParameterizedTest
    @MethodSource("testHowManyBagsAreRequiredForA")
    fun testHowManyBagsAreRequiredForA(bagInstructions: Map<String, BagInstruction>, result: Int) {
        val airport = bagInstructions.toAirport()
        assertThat(airport.howManyBagsAreRequiredForA("shiny gold bag")).isEqualTo(result)
        //assertThat(airport.howManyBagsAreRequiredForA("vibrant plum bag")).isEqualTo(result) // 11
        //assertThat(airport.howManyBagsAreRequiredForA("dark olive bag")).isEqualTo(result) // 7
    }

    companion object {

        @JvmStatic
        fun testHowManyBagsAreRequiredForA(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    mapOf(
                        "shiny gold bag" to "shiny gold bags contain 2 dark red bags.".toInstruction(),
                        "dark red bag" to "dark red bags contain 2 dark orange bags.".toInstruction(),
                        "dark orange bag" to "dark orange bags contain 2 dark yellow bags.".toInstruction(),
                        "dark yellow bag" to "dark yellow bags contain 2 dark green bags.".toInstruction(),
                        "dark green bag" to "dark green bags contain 2 dark blue bags.".toInstruction(),
                        "dark blue bag" to "dark blue bags contain 2 dark violet bags.".toInstruction(),
                        "dark violet bag" to "dark violet bags contain no other bags.".toInstruction(),
                    ),
                    126
                ),
                Arguments.of(
                    mapOf(
                        "light red bag" to "light red bags contain 1 bright white bag, 2 muted yellow bags.".toInstruction(),
                        "dark orange bag" to "dark orange bags contain 3 bright white bags, 4 muted yellow bags.".toInstruction(),
                        "bright white bag" to "bright white bags contain 1 shiny gold bag.".toInstruction(),
                        "muted yellow bag" to "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.".toInstruction(),
                        "shiny gold bag" to "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.".toInstruction(),
                        "dark olive bag" to "dark olive bags contain 3 faded blue bags, 4 dotted black bags.".toInstruction(),
                        "vibrant plum bag" to "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.".toInstruction(),
                        "faded blue bag" to "faded blue bags contain no other bags.".toInstruction(),
                        "dotted black bag" to "dotted black bags contain no other bags.".toInstruction(),
                    ),
                    32
                ),
            )
        }
    }
}