class Solution1325 {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        fun postOrderTraversal(root: TreeNode?, target: Int): TreeNode? =
            if (root == null) null else {
                root.left = postOrderTraversal(root.left, target)
                root.right = postOrderTraversal(root.right, target)
                if (root.left == root.right && root.`val` == target) null else root
            }
        return postOrderTraversal(root, target)
    }
}
