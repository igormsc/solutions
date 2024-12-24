class Solution2773 {
    fun heightOfTree(root: TreeNode?): Int {
        var res = 0

        fun dfs(root: TreeNode?, d: Int) {
            var d = d
            res = maxOf(res, d++)
            if (root!!.left != null && root.left!!.right != root) dfs(root.left, d)
            if (root.right != null && root.right!!.left != root) dfs(root.right, d)
        }

        dfs(root, 0)
        return res
    }

}