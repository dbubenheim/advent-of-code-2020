package advent.of.code.day15

import advent.of.code.toURL
import java.io.File

internal class Day15 {

    companion object {

        @JvmStatic
        internal fun part1(): Long {
            val input = File("day15/input-day15.txt".toURL()).readLines()[0].split(',').map { it.toLong() }
            println("input: $input")
            val rambunctiousRecitation = RambunctiousRecitation(input)
            return rambunctiousRecitation.spokenNumber()
        }

        @JvmStatic
        internal fun part2(): Long {
            val input = File("day15/input-day15.txt".toURL()).readLines()[0].split(',').map { it.toLong() }
            println("input: $input")
            val rambunctiousRecitation = RambunctiousRecitation(input)
            return rambunctiousRecitation.spokenNumber(30000000)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println("part1: ${part1()}")
            println("part2: ${part2()}")
        }
    }

    internal class Node<T>(value: T){
        var value:T = value
        var next: Node<T>? = null
        var previous:Node<T>? = null
    }

    internal class LinkedList<T> {
        private var head:Node<T>? = null
        var isEmpty:Boolean = head == null
        internal fun first():Node<T>? = head
        internal fun last(): Node<T>? {
            var node = head
            return if (node != null){
                while (node?.next != null) {
                    node = node?.next
                }
                node
            } else {
                null
            }
        }
        internal fun count():Int {
            var node = head
            if (node != null){
                var counter = 1
                while (node?.next != null){
                    node = node?.next
                    counter += 1
                }
                return counter
            } else {
                return 0
            }
        }
        internal fun nodeAtIndex(index: Int) : Node<T>? {
            if (index >= 0) {
                var node = head
                var i = index
                while (node != null) {
                    if (i == 0) return node
                    i -= 1
                    node = node.next
                }
            }
            return null
        }
        internal fun append(value: T) {
            var newNode = Node(value)
            var lastNode = this.last()
            if (lastNode != null) {
                newNode.previous = lastNode
                lastNode.next = newNode
            } else {
                head = newNode
            }
        }
        internal fun removeAll() {
            head = null
        }
        internal fun removeNode(node: Node<T>):T {
            val prev = node.previous
            val next = node.next
            if (prev != null) {
                prev.next = next
            } else {
                head = next
            }
            next?.previous = prev
            node.previous = null
            node.next = null
            return node.value
        }
        internal fun removeLast() : T? {
            val last = this.last()
            return if (last != null) {
                removeNode(last)
            } else {
                null
            }
        }
        internal fun removeAtIndex(index: Int):T? {
            val node = nodeAtIndex(index)
            return if (node != null) {
                removeNode(node)
            } else {
                null
            }
        }
        override fun toString(): String {
            var s = "["
            var node = head
            while (node != null) {
                s += "${node.value}"
                node = node.next
                if (node != null) { s += ", " }
            }
            return "$s]"
        }
    }
}