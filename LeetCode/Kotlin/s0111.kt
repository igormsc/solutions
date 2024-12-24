class Solution111 {
    fun minDepth(root: TreeNode?): Int {
        fun dfs(r: TreeNode?): Int =
            when {
                r == null -> 0
                r.left == null && r.right == null -> 1
                r.left == null -> dfs(r.right) + 1
                r.right == null -> dfs(r.left) + 1
                else -> minOf(dfs(r.left), dfs(r.right)) + 1
            }
        return dfs(root)
    }
}
