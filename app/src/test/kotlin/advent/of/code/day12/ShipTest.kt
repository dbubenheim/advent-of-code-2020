package advent.of.code.day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ShipTest {

    @ParameterizedTest
    @MethodSource("provideInputForTestTurn")
    fun testTurn(degrees: Int, direction: Direction) {
        val ship1 = Ship(emptyList())
        ship1.turn(degrees)
        assertThat(ship1.direction).isEqualTo(direction)
    }

    companion object {

        @JvmStatic
        private fun provideInputForTestTurn(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(90, Direction.SOUTH),
                Arguments.of(180, Direction.WEST),
                Arguments.of(270, Direction.NORTH),
                Arguments.of(360, Direction.EAST),
                Arguments.of(-90, Direction.NORTH),
                Arguments.of(-180, Direction.WEST),
                Arguments.of(-270, Direction.SOUTH),
                Arguments.of(-360, Direction.EAST),
                Arguments.of(-450, Direction.SOUTH),
                Arguments.of(-540, Direction.WEST),
                Arguments.of(-630, Direction.NORTH),
                Arguments.of(-720, Direction.EAST),
                Arguments.of(-1080, Direction.EAST),
            );
        }
    }
}
