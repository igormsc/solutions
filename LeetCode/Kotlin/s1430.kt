class Solution1430 {
    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        fun dfs(root: TreeNode?, u: Int): Boolean {
            if (root == null || root.`val` != arr[u]) return false
            if (u == arr.size - 1) return root.left == null && root.right == null
            return dfs(root.left, u + 1) || dfs(root.right, u + 1)
        }

        return dfs(root, 0)
    }

}