class Solution3319 {
    fun kthLargestPerfectSubtree(root: TreeNode?, k: Int): Int {
        val res = mutableListOf<Int>()

        fun dfs(n: TreeNode?): Int {
            if (n == null) return 0
            val (l, r) = dfs(n.left) to dfs(n.right)
            return if (l == r && l >= 0) {
                res.add(l + 1)
                l + 1
            } else -1
        }

        dfs(root)
        res.sort()

        return if (k<=res.size) (1.shl(res[res.size-k])) - 1 else -1
    }
}
