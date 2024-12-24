class Solution549 {
    fun longestConsecutive(root: TreeNode?): Int {
        var res = 0

        fun dfs(root: TreeNode?): IntArray {
            if (root == null) return intArrayOf(0, 0)
            var (incr, decr) = 1 to 1
            val (left, right) = dfs(root.left) to dfs(root.right)
            if (root.left != null) {
                if (root.left!!.`val` + 1 == root.`val`) incr = left[0] + 1
                if (root.left!!.`val` - 1 == root.`val`) decr = left[1] + 1

            }
            if (root.right != null) {
                if (root.right!!.`val` + 1 == root.`val`) incr = maxOf(incr, right[0] + 1)
                if (root.right!!.`val` - 1 == root.`val`) decr = maxOf(decr, right[1] + 1)
            }
            res = maxOf(res, (incr + decr - 1))
            return intArrayOf(incr, decr)
        }

        dfs(root)
        return res
    }

}