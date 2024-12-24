class Solution3157 {
    fun minimumLevel(root: TreeNode?): Int {
        val q = mutableListOf<TreeNode?>()
        q.add(root)
        var res = 0
        var s = Long.MAX_VALUE
        var level = 1
        while (q.isNotEmpty()) {
            var t: Long = 0
            for (m in q.size downTo 1) {
                val node = q.removeFirst()
                t += node!!.`val`.toLong()
                if (node.left != null) q.add(node.left)
                if (node.right != null) q.add(node.right)
            }
            if (s > t) {
                s = t
                res = level
            }
            level++
        }
        return res
    }

}