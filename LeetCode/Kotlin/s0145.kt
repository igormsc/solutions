class Solution145 {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val nodes = mutableListOf<Int>()
        val t = mutableListOf<TreeNode>()
        var last: TreeNode? = null
        var r = root

        while (r != null || t.isNotEmpty()) {
            if (r != null) {
                t.add(r)
                r = r.left
            } else {
                val n = t.last()
                if (n.right != null && last != n.right ) {
                    r = n.right
                } else {
                    nodes.add(n.`val`)
                    last = n
                    t.removeLast()
                }
            }
        }
        return nodes
    }
}
