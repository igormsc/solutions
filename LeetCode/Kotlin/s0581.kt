class Solution581 {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val n = nums.lastIndex
        var (start, end) = -1 to -2
        var (mn, mx) = nums[n] to nums[0]
        (1..n).forEach { i ->
            if (nums[i] >= mx) mx = nums[i] else end = i
            if (mn >= nums[n-i]) mn = nums[n-i] else start = n-i
        }
        return end-start+1
    }
}
