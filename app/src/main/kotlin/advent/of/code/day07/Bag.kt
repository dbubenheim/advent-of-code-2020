package advent.of.code.day07

data class Bag(val name: String, val children: Set<ChildBag>) {

    fun contains(bag : String) : Boolean {

        var result = false
        if (children.any { it.bag.name == bag }) return true

//        contains.forEach {
//            if (it.first.contains(bag)) result = true
//        }

        return result
    }
}