class Solution285 {

    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        var root = root
        var res: TreeNode? = null
        while (root != null) {
            if (p != null) {
                if (root.`val` > p.`val`) {
                    res = root
                    root = root.left
                } else root = root.right
            }

        }
        return res
    }


}