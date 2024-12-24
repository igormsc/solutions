class Solution1602 {
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        var d = 0
        var res: TreeNode? = null

        fun dfs(root: TreeNode?, i: Int) {
            if (root == null || res != null) return
            if (d == i) {
                res = root
                return
            }
            if (root == u) {
                d = i
                return
            }
            dfs(root.left, i + 1)
            dfs(root.right, i + 1)
        }

        dfs(root, 1)
        return res
    }

}