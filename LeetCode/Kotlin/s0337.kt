class Solution337 {
    fun rob(root: TreeNode?): Int = dfs(root).max()

    private fun dfs(root: TreeNode?): IntArray =
        if (root == null) IntArray(2)
        else {
            val (l, r) = dfs(root.left) to dfs(root.right)
            intArrayOf(root.`val` + l[1] + r[1], maxOf(l[0], l[1]) + maxOf(r[0], r[1]))
        }
}
