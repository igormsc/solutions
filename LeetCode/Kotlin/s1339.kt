class Solution1339 {
    fun maxProduct(root: TreeNode?): Int {
        val mod = 1_000_000_007L

        var (sum, res) = 0L to 0L

        fun dfs(n: TreeNode?): Long =
            if (n == null) 0L
            else (dfs(n.left) + dfs(n.right) + n.`val`).also { res = maxOf((sum-it)*it, res) }

        sum = dfs(root)
        res = 0L
        dfs(root)
        return (res % mod).toInt()
    }
}
