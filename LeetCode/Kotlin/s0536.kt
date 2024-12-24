class Solution536 {
    fun str2tree(s: String): TreeNode? {
        fun dfs(s: String): TreeNode? {
            if (s == "") return null
            val p = s.indexOf("(")
            if (p == -1) return TreeNode(s.toInt())

            val root = TreeNode(s.substring(0, p).toInt())
            var start = p
            var cnt = 0
            for (i in p..s.lastIndex) {
                if (s[i] == '(') cnt++
                else if (s[i] == ')') cnt--
                if (cnt == 0)
                    if (start == p) {
                        root.left = dfs(s.substring(start + 1, i))
                        start = i + 1
                    } else root.right = dfs(s.substring(start + 1, i))
            }
            return root
        }

        return dfs(s)
    }


}