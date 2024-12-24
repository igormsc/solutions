class Solution2113 {
    fun elementInNums(nums: IntArray, queries: Array<IntArray>): IntArray {
        val (n, m) = nums.size to queries.size
        val res = IntArray(m)
        for (j in 0..<m) {
            res[j] = -1
            var (t, i) = queries[j]
            t %= (2 * n)
            if (t < n && i < n - t) res[j] = nums[i + t]
            else if (t > n && i < t - n) res[j] = nums[i]
        }
        return res
    }
}