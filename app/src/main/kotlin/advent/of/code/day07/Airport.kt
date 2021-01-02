package advent.of.code.day07

data class Airport(val bagInstructions: Map<String, BagInstruction>) {

    fun howManyBagsCanContainA(bag : String) : Int =
        bagInstructions
            .filter { bagInstruction -> bagInstruction.value.bagContains(bagInstructions, bag) }
            .size

    fun howManyBagsAreRequiredForA(bag: String) : Int {
        bagInstructions[bag]?.let {
            bagInstruction ->
            var sum = 0
            sum += bagInstruction.bag.sumOfChildren(bagInstructions)
            return sum
        }
        return 0
    }
}