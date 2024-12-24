class Solution095 {
    fun generateTrees(n: Int): List<TreeNode?> {

        fun dfs(i: Int, j: Int): List<TreeNode?> {
            val res = mutableListOf<TreeNode?>()
            if (i > j) {
                res.add(null)
                return res
            }
            for (v in i..j) {
                val (left, right) = dfs(i, v - 1) to dfs(v + 1, j)
                for (l in left)
                    for (r in right)
                        res.add(TreeNode(v, l, r))
            }
            return res
        }
        return dfs(1, n)
    }
}