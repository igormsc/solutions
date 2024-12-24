class Solution235 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var cur = root
        while (true) {
            cur = when {
                p!!.`val` < cur!!.`val` && q!!.`val` < cur.`val` -> cur.left
                p.`val` > cur.`val` && q!!.`val` > cur.`val` -> cur.right
                else -> break
            }
        }
        return cur
    }
}
