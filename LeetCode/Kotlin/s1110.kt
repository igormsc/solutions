class Solution1110 {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        val toDel = to_delete.toSet()
        val res = mutableListOf<TreeNode?>()

        fun dfs(n: TreeNode?, isRoot: Boolean): TreeNode? {
            if (n == null) return null
            val deleted = toDel.contains(n.`val`)
            if (isRoot && !deleted) { res.add(n) }
            n.left = dfs(n.left, deleted)
            n.right = dfs(n.right, deleted)
            if (deleted) return null
            return n
        }

        dfs(root, true)
        return res
    }

}
