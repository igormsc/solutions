class Solution250 {

    fun countUnivalSubtrees(root: TreeNode?): Int {
        var res = 0
        fun dfs(root: TreeNode?): Boolean {
            if (root == null) return true
            val (l, r) = dfs(root.left) to dfs(root.right)
            if (!l || !r) return false
            val x = if (root.left == null) root.`val` else root.left!!.`val`
            val y = if (root.right == null) root.`val` else root.right!!.`val`
            if (x == y && y == root.`val`) {
                res++
                return true
            }
            return false
        }

        dfs(root)
        return res
    }

}