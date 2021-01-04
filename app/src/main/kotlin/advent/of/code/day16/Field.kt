package advent.of.code.day16

data class Field(var name : String = "undefined", var position: Int = -1) {

    fun update(fieldName: String, position: Int) {
        this.name = fieldName
        this.position = position
    }
}