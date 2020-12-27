package advent.of.code.day12

data class Units(val units: Int) {

    companion object {
        fun of(input: String) = Units(input.toInt())
    }
}