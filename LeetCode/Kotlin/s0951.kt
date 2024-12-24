class Solution951 {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean =
        when {
            root1 == null && root2 == null -> true
            root1 == null || root2 == null || root1.`val` != root2.`val` -> false
            else -> flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                    flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right)
    }
}