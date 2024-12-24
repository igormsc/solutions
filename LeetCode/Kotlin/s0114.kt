class Solution114 {
    fun flatten(root: TreeNode?): Unit {
        var root = root
        while (root != null) {
            if (root.left != null && root.right != null) {
                var t = root.left
                while (t?.right != null) t = t.right
                t!!.right = root.right
            }
            if (root.left != null) root.right = root.left
            root.left = null
            root = root.right
        }

    }
}
