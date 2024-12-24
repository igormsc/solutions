class Solution998 {
    fun smallestFromLeaf(root: TreeNode?): String {
        fun dfs(n: TreeNode?, s: String): String {
            if (n==null) return s
            val s = ('a'.code + n.`val`).toChar() + s
            if (n.left==null && n.right==null) return s
            if (n.left==null || n.right==null) return dfs(if (n.left==null) n.right else n.left, s)
            return (dfs(n.left,s) to dfs(n.right,s)).let { (l,r) -> if (l<=r) l else r}
        }
        return dfs(root,"")
    }
}
