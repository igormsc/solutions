class Solution298 {
    fun longestConsecutive(root: TreeNode?): Int {
        var res = 0

        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            var l = dfs(root.left) + 1
            var r = dfs(root.right) + 1
            if (root.left != null && root.left!!.`val` - root.`val` != 1) l = 1
            if (root.right != null && root.right!!.`val` - root.`val` != 1) r = 1
            val t = maxOf(l,r)
            res = maxOf(res,t)
            return t
        }

        dfs(root)
        return res
    }

}