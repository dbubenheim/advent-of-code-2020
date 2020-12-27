package advent.of.code.day12

import kotlin.math.abs

class Ship(private val instructions: List<Instruction>) {

    var direction = Direction.EAST
    var position : Position = Position(0,0,0,0)

    fun turn(degrees: Int) {
        println("old direction $direction")
        println("turning $degrees°")
        val newDegrees =  direction.degrees + if (degrees > 0) degrees else abs(360 + degrees)
        when(newDegrees % 360) {
            // TODO Make me prettier
            Direction.NORTH.degrees -> direction = Direction.NORTH
            Direction.EAST.degrees -> direction = Direction.EAST
            Direction.SOUTH.degrees -> direction = Direction.SOUTH
            Direction.WEST.degrees -> direction = Direction.WEST
        }
        println("new direction $direction")
    }

    fun drive() {
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
                Action.LEFT -> this.turn(-it.units.units)
                Action.RIGHT -> this.turn(it.units.units)

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