import kotlin.math.absoluteValue

class Solution272 {
    fun closestKValues(root: TreeNode?, target: Double, k: Int): List<Int> {
        val res = mutableListOf<Int>()

        fun dfs(root: TreeNode?) {
            if (root == null) return
            dfs(root.left)
            if (res.size < k) res.add(root.`val`)
            else {
                if ((root.`val` - target).absoluteValue >= (res.first() - target).absoluteValue) return
                res.removeFirst()
                res.add(root.`val`)
            }
            dfs(root.right)
        }

        dfs(root)
        return res
    }

}