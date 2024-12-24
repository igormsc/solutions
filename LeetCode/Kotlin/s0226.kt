class Solution226 {
    fun invertTree(root: TreeNode?): TreeNode? = if (root == null) null else {
        val (l, r) = root.left to root.right
        root.left = invertTree(r)
        root.right = invertTree(l)
        root
    }

}
