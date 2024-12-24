class Solution1469 {
    fun getLonelyNodes(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()

        fun dfs(root: TreeNode?) {
            if (root == null || (root.left == null && root.right == null)) return
            if (root.left == null) res.add(root.right!!.`val`)
            if (root.right == null) res.add(root.left!!.`val`)

            dfs(root.left)
            dfs(root.right)
        }

        dfs(root)
        return res
    }

}