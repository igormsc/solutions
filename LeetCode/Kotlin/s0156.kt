class Solution156 {
    fun upsideDownBinaryTree(root: TreeNode?): TreeNode? =
        if (root?.left == null) root
        else {
            val newRoot = upsideDownBinaryTree(root.left)
            root.left!!.right = root
            root.left!!.left = root.right
            root.left = null
            root.right = null
            newRoot
        }

}

class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }