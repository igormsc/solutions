class Solution3018 {
    fun maximumProcessableQueries(nums: IntArray, queries: IntArray): Int {
        val n = nums.size
        val f = Array(n) { IntArray(n) }
        val m = queries.size
        for (i in 0..<n)
            for (j in n - 1 downTo i) {
                if (i > 0) f[i][j] = maxOf(f[i][j], (f[i - 1][j] + if (nums[i - 1] >= queries[f[i - 1][j]]) 1 else 0))
                if (j + 1 < n) f[i][j] = maxOf(f[i][j],f[i][j + 1] + if (nums[j + 1] >= queries[f[i][j + 1]]) 1 else 0)
                if (f[i][j] == m) return m
            }
        var res = 0
        for (i in 0..<n)
            res = maxOf(res, f[i][i] + if (nums[i] >= queries[f[i][i]]) 1 else 0)
        return res
    }

}