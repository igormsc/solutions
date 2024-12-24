class Solution2313 {
    fun minimumFlips(root: TreeNode?, result: Boolean): Int {
        fun dfs(root: TreeNode?): IntArray {
            if (root == null) return intArrayOf(Int.MAX_VALUE/2, Int.MAX_VALUE/2)
            val x = root.`val`
            if (x < 2) return intArrayOf(x, x xor 1)
            val (l, r) = dfs(root.left) to dfs(root.right)
            return when (x) {
                2   -> l[0] + r[0] to minOf(l[0] + r[1], l[1] + r[0], l[1] + r[1])
                3   -> minOf(l[0] + r[0], l[0] + r[1], l[1] + r[0]) to l[1] + r[1]
                4   ->  minOf(l[0] + r[0], l[1] + r[1]) to minOf(l[0] + r[1], l[1] + r[0])
                else ->  minOf(l[1], r[1]) to minOf(l[0], r[0])
            }.let{ intArrayOf(it.first,it.second) }
        }
        return dfs(root)[if (result) 1 else 0]
    }

}