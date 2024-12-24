class Solution1740 {
    fun findDistance(root: TreeNode?, p: Int, q: Int): Int {
        val g = lca(root, p, q)
        return dfs(g, p) + dfs(g, q)
    }

    private fun dfs(root: TreeNode?, v: Int): Int {
        if (root == null) return -1
        if (root.`val` == v) return 0
        val (left, right) = dfs(root.left, v) to dfs(root.right, v)
        if (left == -1 && right == -1) return -1
        return 1 + maxOf(left, right)
    }

    private fun lca(root: TreeNode?, p: Int, q: Int): TreeNode? {
        if (root == null || root.`val` == p || root.`val` == q) return root
        val (left, right) = lca(root.left, p, q) to lca(root.right, p, q)
        if (left == null) return right
        if (right == null) return left
        return root
    }

}