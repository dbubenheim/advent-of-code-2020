package advent.of.code.day11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SeatLayoutPart2Test {

    private val seatLayoutPart2 : SeatLayoutPart2 = SeatLayoutPart2(INPUT)

    @Test
    fun testSeatInitialization() {
        assertThat(seatLayoutPart2.seats.size).isEqualTo(9)
        assertThat(seatLayoutPart2.seats[0].size).isEqualTo(9)
        assertThat(seatLayoutPart2.allSeats).isEqualTo(81)
        assertThat(seatLayoutPart2.seats[4][3].isEmpty()).isTrue()
    }

    @Test
    fun testGetUp() {
        assertThat(seatLayoutPart2.getUp(SeatPosition(0,0))).isNull()
        assertThat(seatLayoutPart2.getUp(SeatPosition(0,1))).isNull()
        assertThat(seatLayoutPart2.getUp(SeatPosition(4,4))).isNull()
        assertThat(seatLayoutPart2.getUp(SeatPosition(3,4))!!.isOccupied()).isTrue()
    }

    @Test
    fun testGetUpRight() {
        assertThat(seatLayoutPart2.getUpRight(SeatPosition(0,0))).isNull()
        assertThat(seatLayoutPart2.getUpRight(SeatPosition(0,8))).isNull()
        assertThat(seatLayoutPart2.getUpRight(SeatPosition(4,4))).isNull()
        assertThat(seatLayoutPart2.getUpRight(SeatPosition(3,4))!!.isOccupied()).isTrue()
    }

    @Test
    fun testGetRight() {
        assertThat(seatLayoutPart2.getRight(SeatPosition(8,0))).isNull()
        assertThat(seatLayoutPart2.getRight(SeatPosition(6,0))!!.isOccupied()).isTrue()
        assertThat(seatLayoutPart2.getRight(SeatPosition(3,4))!!.isOccupied()).isTrue()
    }

    @Test
    fun testGetDownRight() {
        assertThat(seatLayoutPart2.getDownRight(SeatPosition(0,0))).isNull()
        assertThat(seatLayoutPart2.getDownRight(SeatPosition(0,1))!!.isOccupied()).isTrue()
        assertThat(seatLayoutPart2.getDownRight(SeatPosition(4,4))).isNull()
        assertThat(seatLayoutPart2.getDownRight(SeatPosition(3,4))!!.isOccupied()).isTrue()
    }

    @Test
    fun testGetDown() {
        assertThat(seatLayoutPart2.getDown(SeatPosition(0,8))).isNull()
        assertThat(seatLayoutPart2.getDown(SeatPosition(3,0))!!.isOccupied()).isTrue()
        assertThat(seatLayoutPart2.getDown(SeatPosition(3,4))!!.isOccupied()).isTrue()
    }

    @Test
    fun testGetDownLeft() {
        assertThat(seatLayoutPart2.getDownLeft(SeatPosition(0,2))).isNull()
        assertThat(seatLayoutPart2.getDownLeft(SeatPosition(4,8))).isNull()
        assertThat(seatLayoutPart2.getDownLeft(SeatPosition(0,1))).isNull()
        assertThat(seatLayoutPart2.getDownLeft(SeatPosition(4,4))).isNull()
        assertThat(seatLayoutPart2.getDownLeft(SeatPosition(3,4))!!.isOccupied()).isTrue()
    }

    @Test
    fun testGetLeft() {
        assertThat(seatLayoutPart2.getLeft(SeatPosition(0,0))).isNull()
        assertThat(seatLayoutPart2.getLeft(SeatPosition(0,8))).isNull()
        assertThat(seatLayoutPart2.getLeft(SeatPosition(4,4))!!.isEmpty()).isTrue()
        assertThat(seatLayoutPart2.getLeft(SeatPosition(3,4))!!.isOccupied()).isTrue()
        assertThat(seatLayoutPart2.getLeft(SeatPosition(8,8))!!.isOccupied()).isTrue()
    }

    @Test
    fun testGetUpLeft() {
        assertThat(seatLayoutPart2.getUpLeft(SeatPosition(0,0))).isNull()
        assertThat(seatLayoutPart2.getUpLeft(SeatPosition(0,8))).isNull()
        assertThat(seatLayoutPart2.getUpLeft(SeatPosition(4,0))).isNull()
        assertThat(seatLayoutPart2.getUpLeft(SeatPosition(4,4))).isNull()
        assertThat(seatLayoutPart2.getUpLeft(SeatPosition(3,4))!!.isOccupied()).isTrue()
    }

    companion object {

        val INPUT = listOf(
            ".......#.",
            "...#.....",
            ".#.......",
            ".........",
            "..#L....#",
            "....#....",
            ".........",
            "#........",
            "...#.....",
        )
    }
}