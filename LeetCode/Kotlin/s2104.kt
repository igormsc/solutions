class Solution2104 {
    fun subArrayRanges(nums: IntArray): Long =
        (0..<nums.lastIndex).sumOf { i ->
            var (mn, mx) = nums[i] to nums[i]
            (i + 1..nums.lastIndex).sumOf { j ->
                mn = minOf(mn, nums[j])
                mx = maxOf(mx, nums[j])
                (mx - mn).toLong()
            }
        }
}
