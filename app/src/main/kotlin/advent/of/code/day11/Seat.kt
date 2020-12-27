package advent.of.code.day11

internal class Seat(var type : SeatType, val position: SeatPosition) {

    var update : SeatUpdate? = null

    internal fun update() {
        update?.let {
            this.type = it.newType
        }
        update = null
    }

    internal fun needsUpdate() = update != null

    internal fun isSeat() = this.isOccupied() || this.isEmpty()
    internal fun isOccupied() = this.type == SeatType.OCCUPIED
    internal fun isEmpty() = this.type == SeatType.EMPTY

    override fun toString() = this.type.toString() + "$position"
}