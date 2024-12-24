class Solution2415 {
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        var odd = true
        val q = mutableListOf(root)
        while (q.isNotEmpty()) {
            val t = mutableListOf<TreeNode?>()
            for (k in q.size downTo 1) {
                val node = q.removeFirst()
                if (odd) t.add(node)
                if (node!!.left != null)
                    q.addAll(listOf(node.left, node.right))
            }
            var (l, r) = 0 to t.lastIndex
            while (l < r)
                t[l]!!.`val` = t[r]!!.`val`.also{t[r--]!!.`val` = t[l++]!!.`val`}
            odd = !odd
        }
        return root
    }
}
