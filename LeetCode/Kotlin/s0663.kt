class Solution663 {
    fun checkEqualTree(root: TreeNode?): Boolean {
        val vis = mutableListOf<Int>()

        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            val (l, r) = dfs(root.left) to dfs(root.right)
            val s = l + r + root.`val`
            vis.add(s)
            return s
        }

        val s = dfs(root)
        if (s % 2 != 0) return false
        vis.removeLast()

        return vis.contains(s / 2)
    }
}