package advent.of.code.day12

import kotlin.math.abs

internal class ShipPart2(private val instructions: List<Instruction>) : Ship {

    var position = Position(0, 0)
    var waypoint = Waypoint(Position(10, 1))

    override fun turn(degrees: Int) {
        println("old waypoint: $waypoint")
        println("turning: $degrees°")

        val clockwise = degrees >= 0
        val oldX = waypoint.position.x
        val oldY = waypoint.position.y
        val newPosition: Position = when (abs(degrees) % 360) {
            90 -> if (clockwise) Position(oldY, -oldX) else Position(-oldY, oldX)
            180 -> Position(-oldX, -oldY)
            270 -> if (clockwise) Position(-oldY, oldX) else Position(oldY, -oldX)
            else -> Position(oldX, oldY)
        }
        waypoint.position = newPosition
        println("new waypoint: $waypoint")
    }

    override fun drive() {
        println("ship is driving")
        println("starting position: $position")
        instructions.forEach { instruction ->

            println(instruction)

            when (instruction.action) {

                Action.FORWARD -> {
                    val xUnits = waypoint.position.x * instruction.units
                    val yUnits = waypoint.position.y * instruction.units

                    position.east(xUnits)
                    position.north(yUnits)
                }

                Action.LEFT -> turn(-instruction.units)
                Action.RIGHT -> turn(instruction.units)

                Action.NORTH -> waypoint.north(instruction.units)
                Action.EAST -> waypoint.east(instruction.units)
                Action.SOUTH -> waypoint.south(instruction.units)
                Action.WEST -> waypoint.west(instruction.units)
            }
        }

        println("ship finished driving")
        println("final position: $position")
    }
}