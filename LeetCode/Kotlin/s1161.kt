class Solution1161 {
    fun maxLevelSum(root: TreeNode?): Int {
        val sums = mutableListOf<Int>()

        fun dfs (r: TreeNode?, lvl: Int) {
            if (r==null) return
            while (sums.size < lvl) sums.add(0)
            sums[lvl-1] += r.`val`
            dfs(r.left, lvl+1)
            dfs(r.right, lvl+1)
        }

        dfs(root, 1)
        var mx = sums[0]
        var l = 0
        sums.forEachIndexed {i, s ->
            if (s>mx) {
                mx = s
                l = i
            }
        }
        return l+1
    }
}
