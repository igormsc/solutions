class Solution3347 {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        val cnt = mutableMapOf<Int, Int>()
        var (res, i, j) = intArrayOf(0,0,0)
        val n = nums.size
        nums.sort()
        for (v in nums) {
            while (j < n && nums[j] <= v + k)
                cnt[nums[j]] = (cnt[nums[j++]]?:0) + 1
            while (i < n && nums[i] < v - k)
                cnt[nums[i]] = cnt[nums[i++]]!! - 1
            val cur = minOf(j - i, (cnt[v]?:0) + numOperations)
            res = maxOf(res, cur)
        }
        i = 0
        j = 0
        while (j < n) {
            while (nums[i].toLong() + k.toLong() + k.toLong() < nums[j].toLong()) i++
            res = maxOf(res, minOf(j - i + 1, numOperations))
            j++
        }
        return res
    }
}
