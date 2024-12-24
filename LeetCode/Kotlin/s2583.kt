class Solution2583 {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {

        val lSum = mutableListOf<Long>()

        fun traverse(n: TreeNode?, depth: Int) {
            if (n == null) return
            if (lSum.size == depth) lSum.add(0)
            lSum[depth] += n.`val`.toLong()
            traverse(n.left, depth + 1)
            traverse(n.right, depth + 1)
        }

        traverse(root, 0)
        return if (lSum.size<k) -1 else {
            lSum.sortDescending()
            lSum[k-1]
        }
    }
}
