import kotlin.math.absoluteValue

class Solution270 {
    fun closestValue(root: TreeNode?, target: Double): Int {
        var res = 0
        var diff = Double.MAX_VALUE

        fun dfs(node: TreeNode?) {
            if (node == null) return
            val next = (node.`val` - target).absoluteValue
            if (next < diff || (next == diff && node.`val` < res)) {
                diff = next
                res = node.`val`
            }
            dfs(if (target < node.`val`) node.left else node.right)
        }

        dfs(root)
        return res
    }

}