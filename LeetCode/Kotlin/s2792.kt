import java.util.*
import kotlin.Comparator

class Solution2792 {
    fun countGreatEnoughNodes(root: TreeNode?, k: Int): Int {
        var res = 0

        fun dfs(root: TreeNode?): PriorityQueue<Int> {
            if (root == null) return PriorityQueue(Comparator.reverseOrder())
            val l = dfs(root.left)
            val r = dfs(root.right)
            for (x in r) {
                l.offer(x)
                if (l.size > k) l.poll()
            }
            if (l.size == k && l.peek() < root.`val`) res++
            l.offer(root.`val`)
            if (l.size > k) l.poll()
            return l
        }

        dfs(root)
        return res
    }

}