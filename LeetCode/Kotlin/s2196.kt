 class Solution2196 {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val parent= mutableMapOf<Int,Int>()
        val left = mutableMapOf<Int,Int>()
        val right = mutableMapOf<Int,Int>()

        descriptions.forEach { d ->
            parent[d[1]] = d[0]
            if (d[2]==1) left[d[0]] = d[1] else right[d[0]] = d[1]
        }
        val rt = parent.values.find{ !parent.containsKey(it) }?:0
        val root = TreeNode(rt)

        fun dfs(n: TreeNode, left: MutableMap<Int,Int>, right: MutableMap<Int,Int>) {
            if (left.containsKey(n.`val`)) {
                val ln = TreeNode(left[n.`val`]!!)
                n.left = ln
                dfs(n.left!!, left, right)
                }
            if (right.containsKey(n.`val`)) {
                val rn = TreeNode(right[n.`val`]!!)
                n.right = rn
                dfs(n.right!!, left, right)
                }
        }

        dfs(root, left, right)
        return root
    }

}
