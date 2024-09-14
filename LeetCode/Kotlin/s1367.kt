
class Solution1367 {
    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean =
        if (root == null) false
        else find(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right)

    private fun find(head : ListNode?, root : TreeNode?) : Boolean = when {
            head == null -> true
            root == null -> false
            else -> head.`val` == root.`val` && (find(head.next, root.left) || find(head.next, root.right)) }
}
