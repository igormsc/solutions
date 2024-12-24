class Solution1372 {
    fun longestZigZag(root: TreeNode?): Int = dfs(root) [2]

    private fun dfs(node: TreeNode?): IntArray {
        if (node == null) return intArrayOf(-1,-1,-1)
        val (l, r) = dfs(node.left) to dfs(node.right)
        return intArrayOf(l[1]+1, r[0] +1, maxOf(maxOf(l[1],r[0])+1, maxOf(l[2],r[2])))
    }
}
