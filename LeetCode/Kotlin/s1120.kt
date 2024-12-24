class Solution1120 {
    fun maximumAverageSubtree(root: TreeNode?): Double {
        var res = 0.0

        fun dfs(root: TreeNode?): IntArray {
            if (root == null) return IntArray(2)
            val (l, r) = dfs(root.left) to dfs(root.right)
            val s = root.`val` + l[0] + r[0]
            val n = 1 + l[1] + r[1]
            res = maxOf(res, s * 1.0 / n)
            return intArrayOf(s, n)
        }

        dfs(root)
        return res
    }

}