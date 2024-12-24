class Solution3346 {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        nums.sort()
        val cnt = mutableMapOf<Int, Int>()
        var (i, j, res) = intArrayOf(0, 0, 0)
        val sz = nums.size
        for (n in nums) {
            while (j < sz && nums[j] <= n + k)
                cnt[nums[j]] = (cnt[nums[j++]] ?: 0) + 1
            while (i < sz && nums[i] < n - k)
                cnt[nums[i]] = cnt[nums[i++]]!! - 1
            val cur = minOf(j - i, (cnt[n] ?: 0) + numOperations)
            res = maxOf(res, cur)
        }
        i = 0
        j = 0
        while (j < sz) {
            while (nums[i] + k + k < nums[j]) i++
            res = maxOf(res, minOf(j - i + 1, numOperations))
            j++
        }
        return res
    }
}