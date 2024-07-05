class Solution1038 {
    fun bstToGst(root: TreeNode?): TreeNode? {
        var pre = 0
        fun bst(n: TreeNode?): TreeNode? {
            if (n?.right != null) bst(n.right)
            n!!.`val` += pre
            pre = n!!.`val`
            if (n.left != null) bst(n.left)
            return n
        }
        return bst(root)
    }
}
