import kotlin.math.absoluteValue

class Solution979 {
    fun distributeCoins(root: TreeNode?): Int {
        var res = 0

        fun dfs(r: TreeNode?): Int =
            if (r == null) 0
            else
                (dfs(r.left) to dfs(r.right)).let { (left, right) ->
                    res += left.absoluteValue + right.absoluteValue
                    r.`val` + left + right - 1
                }


        dfs(root)
        return res
    }

}

