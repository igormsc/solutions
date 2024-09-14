class Solution3225 {
    fun maximumScore(grid: Array<IntArray>): Long {
        val n = grid.size
        val (dp1, dp2) = LongArray(n) to LongArray(n)
        var (res, p1, p2) = longArrayOf(0,0,0)
        var i = 0

        fun sc(dp: LongArray, col: Int, pr: Long, row: Int, d: Int, e: Int): Long {
            var pr = pr
            var row = row
            var mx = 0L
            while (row != e) {
                mx = maxOf(mx, pr)
                pr = dp[row]
                mx += grid[row][col].toLong()
                dp[row] = mx
                row += d
            }
            return mx
        }

        while (i < n-1) {
            val cur = sc(dp1, i, p1, 0, 1, n)
            p1 = maxOf(res, p2)
            p2 = sc(dp2, i+1, res, n-1, -1, -1)
            res = maxOf(p1, cur)
            i++
        }
        return maxOf(res, p2)
    }
}