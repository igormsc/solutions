class Solution3276 {
    fun maxScore(grid: List<List<Int>>): Int {
        val dp = Array(101) {IntArray(1025) {-1}}
        val nums = Array(101) {mutableListOf<Int>()}

        fun f(n: Int, mask: Int): Int =
            when {
                n == 0 -> 0
                dp[n][mask] != -1 -> dp[n][mask]
                else -> {
                    var res = f(n - 1, mask)
                    nums[n].forEach { r ->
                        val b = 1.shl(r)
                        if (mask.and(b) == 0) res = maxOf(res, f(n - 1, mask.or(b)) + n)
                    }
                    dp[n][mask] = res
                    res
                }
        }

        for (i in grid.indices)
            for (g in grid[i]) nums[g].add(i)

        return f(100,0)
    }
}