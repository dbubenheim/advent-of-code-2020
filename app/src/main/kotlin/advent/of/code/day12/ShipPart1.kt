package advent.of.code.day12

import kotlin.math.abs

class ShipPart1(private val instructions: List<Instruction>) : Ship {

    var direction = Direction.EAST
    var position = Position(0, 0)

    override fun turn(degrees: Int) {
        println("old direction: $direction")
        println("turning: $degrees°")
        val newDegrees =  (direction.degrees + if (degrees > 0) degrees else abs(360 + degrees)) % 360
        direction = Direction.of(newDegrees)
        println("new direction: $direction")
    }

    override fun drive() {
        println("ship is driving")
        println("starting position: $position")
        instructions.forEach {
            println(it)

            when (it.action) {

                Action.FORWARD -> {
                    when(direction) {
                        Direction.NORTH -> this.position.north(it.units)
                        Direction.EAST -> this.position.east(it.units)
                        Direction.SOUTH -> this.position.south(it.units)
                        Direction.WEST -> this.position.west(it.units)
                    }
                }

                Action.LEFT -> this.turn(-it.units)
                Action.RIGHT -> this.turn(it.units)

                Action.NORTH -> this.position.north(it.units)
                Action.EAST -> this.position.east(it.units)
                Action.SOUTH -> this.position.south(it.units)
                Action.WEST -> this.position.west(it.units)
            }
        }

        println("ship finished driving")
        println("final position: $position")
    }
}