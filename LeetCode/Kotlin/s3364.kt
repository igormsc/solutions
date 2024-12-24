class Solution3364 {
    fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
        val n = nums.size
        var min = Int.MAX_VALUE

        (l..r).forEach { q ->
            var cur = 0
            (0..<q).forEach{ cur += nums[it] }
            if (cur > 0) min = minOf(min, cur)
            (q..<n).forEach {
                cur += nums[it] - nums[it-q]
                if (cur > 0) min = minOf(min, cur)
            }
        }
        return if (min == Int.MAX_VALUE) -1 else min
    }
}
