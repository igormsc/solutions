class Solution1214 {
    fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
        val nums =  Array(2) {mutableListOf<Int>()}

        fun dfs(root: TreeNode?, i: Int) {
            if (root == null) return
            dfs(root.left, i)
            nums[i].add(root.`val`)
            dfs(root.right, i)
        }

        dfs(root1, 0)
        dfs(root2, 1)
        var (i, j) = 0 to nums[1].lastIndex
        while (i < nums[0].size && j >= 0) {
            val x = nums[0][i] + nums[1][j]
            if (x == target) return true
            if (x < target) i++
            else j--
        }
        return false
    }

}