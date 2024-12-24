class Solution104 {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val lst = mutableListOf(root)
        var depth = 0
        var cnt = 1
        while (lst.isNotEmpty()) {
            val n = lst.removeFirst()
            if (n.left != null) lst.add(n.left!!)
            if (n.right != null) lst.add(n.right!!)
            if (--cnt == 0) {
                depth++
                cnt = lst.size
            }
        }
        return depth
    }
}