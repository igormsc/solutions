class Solution968 {
    fun minCameraCover(root: TreeNode?): Int {

        fun dfs(n: TreeNode?, b1: Boolean, b2: Boolean): Int =
            when {
                n == null -> 0
                b1 -> dfs(n.left, false, true) + dfs(n.right, false, true) + 1
                b2 -> minOf(dfs(n.left, false, false) + dfs(n.right, false, false), dfs(n.left, false, true) + dfs(n.right, false, true) + 1)
                n.`val` != 0 -> n.`val`
                else -> minOf (dfs(n.left, false, true) + dfs(n.right, false, true) + 1,
                            if (n.left == null) Int.MAX_VALUE else dfs(n.left, true, false) + dfs(n.right, false, false),
                            if (n.right == null) Int.MAX_VALUE else dfs(n.left, false, false) + dfs(n.right, true, false)).also{n.`val`=it} }

        return dfs(root, false, false)
    }
}
