import java.util.*
import kotlin.collections.ArrayList

class Solution314 {
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        val d = TreeMap<Int, MutableList<IntArray>>()

        fun dfs(root: TreeNode?, depth: Int, offset: Int) {
            if (root == null) return
            d.computeIfAbsent(offset) { mutableListOf() }.add(intArrayOf(depth, root.`val`))
            dfs(root.left, depth + 1, offset - 1)
            dfs(root.right, depth + 1, offset + 1)
        }

        dfs(root, 0, 0)
        val res: MutableList<List<Int>> = ArrayList()
        for (v in d.values) {
            v.sortBy { it[0] }
            val t = mutableListOf<Int>()
            for (e in v) t.add(e[1])
            res.add(t)
        }
        return res
    }


}