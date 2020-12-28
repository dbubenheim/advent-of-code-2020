package advent.of.code.day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ShipPart2Test {

    @ParameterizedTest
    @MethodSource("provideInputForTestDrive")
    fun testDrive(instructions: List<Instruction>,
                  positionStart: Position,
                  positionEnd: Position,
                  waypointStart: Waypoint,
                  waypointEnd: Waypoint) {

        val ship = ShipPart2(instructions)
        ship.position = positionStart
        ship.waypoint = waypointStart
        ship.drive()
        assertThat(ship.position).isEqualTo(positionEnd)
        assertThat(ship.waypoint).isEqualTo(waypointEnd)
    }

    @ParameterizedTest
    @MethodSource("provideInputForTestTurn")
    fun testTurn(degrees: Int, waypointStart: Waypoint, waypointEnd: Waypoint) {
        val ship = ShipPart2(emptyList())
        ship.waypoint = waypointStart
        ship.turn(degrees)
        assertThat(ship.waypoint).isEqualTo(waypointEnd)
    }

    companion object {

        @JvmStatic
        private fun provideInputForTestDrive(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf("N3").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 1),
                    Waypoint(10, 4)
                ),
                Arguments.of(
                    listOf("S6").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 1),
                    Waypoint(10, -5)
                ),
                Arguments.of(
                    listOf("E2").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 1),
                    Waypoint(12, 1)
                ),
                Arguments.of(
                    listOf("W7").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 1),
                    Waypoint(3, 1)
                ),
                Arguments.of(
                    listOf("L90").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 1),
                    Waypoint(-1, 10)
                ),
                Arguments.of(
                    listOf("R90").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 1),
                    Waypoint(1, -10)
                ),
                Arguments.of(
                    listOf("L180").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 4),
                    Waypoint(-10, -4)
                ),
                Arguments.of(
                    listOf("R180").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 4),
                    Waypoint(-10, -4)
                ),
                Arguments.of(
                    listOf("R180").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(-1, 10),
                    Waypoint(1, -10)
                ),
                Arguments.of(
                    listOf("L270").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 4),
                    Waypoint(4, -10)
                ),
                Arguments.of(
                    listOf("R270").toInstructions(),
                    Position(0, 0),
                    Position(0, 0),
                    Waypoint(10, 4),
                    Waypoint(-4, 10)
                ),
                Arguments.of(
                    listOf("F10").toInstructions(),
                    Position(0, 0),
                    Position(100, 40),
                    Waypoint(10, 4),
                    Waypoint(10, 4)
                ),
                Arguments.of(
                    listOf("F7").toInstructions(),
                    Position(0, 0),
                    Position(70, 7),
                    Waypoint(10, 1),
                    Waypoint(10, 1)
                ),
                Arguments.of(
                    listOf("F11").toInstructions(),
                    Position(0, 0),
                    Position(110, 11),
                    Waypoint(10, 1),
                    Waypoint(10, 1)
                ),
                Arguments.of(
                    listOf("F10", "N3").toInstructions(),
                    Position(0, 0),
                    Position(100, 10),
                    Waypoint(10, 1),
                    Waypoint(10, 4)
                ),
                Arguments.of(
                    listOf("F10", "N3", "F7").toInstructions(),
                    Position(0, 0),
                    Position(170, 38),
                    Waypoint(10, 1),
                    Waypoint(10, 4)
                ),
                Arguments.of(
                    listOf("F10", "N3", "F7", "R90").toInstructions(),
                    Position(0, 0),
                    Position(170, 38),
                    Waypoint(10, 1),
                    Waypoint(4, -10)
                ),
                Arguments.of(
                    listOf("F10", "N3", "F7", "R90", "F11").toInstructions(),
                    Position(0, 0),
                    Position(214, -72),
                    Waypoint(10, 1),
                    Waypoint(4, -10)
                )
            )
        }

        @JvmStatic
        private fun provideInputForTestTurn(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    90,
                    Waypoint(10, 4),
                    Waypoint(4, -10)
                ),
                Arguments.of(
                    -90,
                    Waypoint(10, 4),
                    Waypoint(-4, 10)
                ),
                Arguments.of(
                    180,
                    Waypoint(10, 4),
                    Waypoint(-10, -4)
                ),
                Arguments.of(
                    -180,
                    Waypoint(-10, 4),
                    Waypoint(10, -4)
                ),
                Arguments.of(
                    270,
                    Waypoint(10, 4),
                    Waypoint(-4, 10)
                ),
                Arguments.of(
                    -270,
                    Waypoint(10, 4),
                    Waypoint(4, -10)
                ),
                Arguments.of(
                    360,
                    Waypoint(-10, -4),
                    Waypoint(-10, -4)
                ),
                Arguments.of(
                    -360,
                    Waypoint(10, 4),
                    Waypoint(10, 4)
                ),
                Arguments.of(
                    90,
                    Waypoint(2, 3),
                    Waypoint(3, -2)
                ),
                Arguments.of(
                    -90,
                    Waypoint(2, 3),
                    Waypoint(-3, 2)
                ),
                Arguments.of(
                    180,
                    Waypoint(2, 3),
                    Waypoint(-2, -3)
                ),
                Arguments.of(
                    -180,
                    Waypoint(2, 3),
                    Waypoint(-2, -3)
                ),
                Arguments.of(
                    270,
                    Waypoint(2, 3),
                    Waypoint(-3, 2)
                ),
                Arguments.of(
                    -270,
                    Waypoint(2, 3),
                    Waypoint(3, -2)
                ),
                Arguments.of(
                    360,
                    Waypoint(2, 3),
                    Waypoint(2, 3)
                ),
                Arguments.of(
                    -360,
                    Waypoint(-2, 3),
                    Waypoint(-2, 3)
                ),
            )
        }
    }
}