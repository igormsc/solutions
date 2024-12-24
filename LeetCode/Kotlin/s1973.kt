class Solution1973 {
    fun equalToDescendants(root: TreeNode?): Int {
        var res = 0

        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            val (l, r) = dfs(root.left) to dfs(root.right)
            if (l + r == root.`val`) res++
            return root.`val` + l + r
        }

        dfs(root)
        return res
    }

}