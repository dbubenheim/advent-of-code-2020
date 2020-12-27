package advent.of.code.day12

class Position(
    var north: Int,
    var east: Int,
    var south: Int,
    var west: Int,
) {

    fun north(units: Units) {
        this.north += units.units
        this.south -= units.units
    }

    fun east(units: Units) {
        this.east += units.units
        this.west -= units.units
    }

    fun south(units: Units) {
        this.south += units.units
        this.north -= units.units
    }

    fun west(units: Units) {
        this.west += units.units
        this.east -= units.units
    }

    override fun toString() = "($north,$east,$south,$west)"
}
