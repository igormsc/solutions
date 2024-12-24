class Solution1265 {
    fun printLinkedListInReverse(head:ImmutableListNode?) {
        if (head != null) {
            printLinkedListInReverse(head.getNext())
            head.printValue()
        }
    }
}

abstract class ImmutableListNode {
    abstract fun printValue(): Unit
    abstract fun getNext(): ImmutableListNode?
}