class Solution2471 {
    fun minimumOperations(root: TreeNode?): Int {
        var res = 0
        var q = mutableListOf(root)
        while (q.isNotEmpty()) {
            val q1 = mutableListOf<TreeNode?>()
            val ids = mutableListOf<Pair<Int,Int>>()
            q.forEachIndexed { i, n ->
                ids.add(i to n!!.`val`)
                if (n.left != null) q1.add(n.left)
                if (n.right != null) q1.add(n.right)
            }
            ids.sortBy { it.second }
            ids.indices.forEach { i ->
                while (ids[i].first != i) {
                    res++
                    ids[i] = ids[ids[i].first].also{ids[ids[i].first] = ids[i]}
                }
            }
            q = q1
        }
        return res
    }
}
