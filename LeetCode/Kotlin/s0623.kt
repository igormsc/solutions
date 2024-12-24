class Solution623 {
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? = when {
        depth < 2     -> {
                        val node = TreeNode(`val`)
                        if (depth == 0) node.right = root else node.left = root
                        node }
        root == null -> null
        depth == 2   -> {
                        root.left = addOneRow(root.left, `val`, 1)
                        root.right = addOneRow(root.right, `val`, 0)
                        root }
        else        -> {
                        root.left = addOneRow(root.left, `val`, depth - 1)
                        root.right = addOneRow(root.right, `val`, depth - 1)
                        root }
    }
}

