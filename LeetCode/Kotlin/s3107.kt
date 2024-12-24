class Solution3107 {
    fun minOperationsToMakeMedianK(nums: IntArray, k: Int): Long {
        nums.sort()
        val n = nums.size
        val r = (0..n / 2).fold(0L) { r, i -> r + maxOf(0, nums[i] - k) }
        return (n / 2..<n).fold(r) { r, i -> r + maxOf(0, k - nums[i]) }
    }
}

