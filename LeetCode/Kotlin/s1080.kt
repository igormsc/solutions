class Solution1080 {
    fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
        if (root == null) return null
        if (root.left == null && root.right == null) {
            if (root.`val` < limit) return null
            return root
        }
        root.left = sufficientSubset(root.left, limit - root.`val`)
        root.right = sufficientSubset(root.right, limit - root.`val`)
        if (root.left == root.right) return null
        return root
    }
}
