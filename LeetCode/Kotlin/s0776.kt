class Solution776 {
    fun splitBST(root: TreeNode?, target: Int): Array<TreeNode?> {

        fun dfs(root: TreeNode?): Array<TreeNode?> {
            if (root == null) return arrayOf(null, null)
            if (root.`val` <= target) {
                val res = dfs(root.right)
                root.right = res[0]
                res[0] = root
                return res
            } else {
                val res = dfs(root.left)
                root.left = res[1]
                res[1] = root
                return res
            }
        }

        return dfs(root)
    }

}