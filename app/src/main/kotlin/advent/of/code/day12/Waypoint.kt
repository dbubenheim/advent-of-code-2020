package advent.of.code.day12

data class Waypoint(var position: Position) {

    constructor(x: Int, y: Int) : this(Position(x, y))

    fun north(units: Int) {
        this.position.north(units)
    }

    fun east(units: Int) {
        this.position.east(units)
    }

    fun south(units: Int) {
        this.position.south(units)
    }

    fun west(units: Int) {
        this.position.west(units)
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other?.javaClass != javaClass) return false
        if (other !is Waypoint) return false
        return other.position == position
    }

    override fun hashCode() = position.hashCode()
}