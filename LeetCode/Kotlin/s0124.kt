class Solution124 {
    fun maxPathSum(root: TreeNode?): Int {
        var  maxSum = Int.MIN_VALUE
        fun dfs(root: TreeNode?): Int = root?.`val`?.let { v ->
            val lr = Pair(maxOf(dfs(root.left),0), maxOf(dfs(root.right), 0))
            maxSum = maxOf(maxSum, root.`val`+lr.first+lr.second)
            v + maxOf(lr.first,lr.second) } ?: 0

        dfs(root)
        return maxSum
    }
}