class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution404 {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        var sumLeft = 0
        fun dfs(r: TreeNode?, left: Boolean) {
            if (r == null) return
            if (r.left == null && r.right == null) {
                if (left) sumLeft += r.`val`
                return
            }
            dfs(r.left, true)
            dfs(r.right, false)
        }
        dfs(root, false)
        return sumLeft
    }

}
