class Solution366 {
    fun findLeaves(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()

        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            val (l, r) = dfs(root.left) to dfs(root.right)
            val h = maxOf(l, r)
            if (res.size == h) res.add(mutableListOf())
            res[h].add(root.`val`)
            return h + 1
        }

        dfs(root)
        return res
    }

}