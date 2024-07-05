class Solution2331 {
    fun evaluateTree(root: TreeNode?): Boolean =
        when (root?.`val`) {
            0, 1    -> root.`val` != 0
            2       -> evaluateTree(root.left) || evaluateTree(root.right)
            else    -> evaluateTree(root?.left) && evaluateTree(root?.right)
        }
}
