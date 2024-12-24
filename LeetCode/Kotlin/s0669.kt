class Solution669 {
    fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? =
        when {
            root == null -> root
            root.`val` > high -> trimBST(root.left, low, high)
            root.`val` < low -> trimBST(root.right, low, high)
            else -> {
                root . left = trimBST (root.left, low, high)
                root.right = trimBST(root.right, low, high)
                 root
        }
    }
}