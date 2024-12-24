class Solution333 {
    fun largestBSTSubtree(root: TreeNode?): Int {
        var res = 0

        fun dfs(root: TreeNode?): IntArray {
            if (root == null) return intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE, 0)
            val (left, right) = dfs(root.left) to dfs(root.right)
            if (left[1] < root.`val` && root.`val` < right[0]) {
                res = maxOf(res, left[2] + right[2] + 1)
                return intArrayOf(minOf(root.`val`, left[0]), maxOf(root.`val`, right[1]), left[2] + right[2] + 1)
            }
            return intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE, 0)
        }

        dfs(root)
        return res
    }

}