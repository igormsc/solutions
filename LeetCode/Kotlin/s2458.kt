class Solution2458 {
    fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
        val level = IntArray(100_001)
        val depth = IntArray(100_001)
        val d1 = IntArray(100_001)
        val d2 = IntArray(100_001)

        fun traverse (n: TreeNode?, l: Int): Int =
            if (n == null) 0
            else {
                level[n.`val`] = l
                depth[n.`val`] = 1 + maxOf(traverse(n.left, l+1), traverse(n.right, l+1))
                if (d1[l] < depth[n.`val`]) {
                    d2[l] = d1[l]
                    d1[l] = depth[n.`val`]
                } else if (d2[l] < depth[n.`val`]) d2[l] = depth[n.`val`]
                depth[n.`val`]
            }

        traverse(root, 0)
        queries.forEachIndexed { i, q ->
            val l = level[q]
            queries[i] = l-1
            queries[i] += if (d1[l] == depth[q]) d2[l] else d1[l]
        }
        return queries
    }
}

