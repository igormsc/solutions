class Solution053 {
    fun maxSubArray(nums: IntArray): Int {
        var (sum, mx) = nums[0] to nums[0]
        nums.drop(1).forEach { n ->
            sum = maxOf(sum+n, n)
            mx = maxOf(mx, sum)
        }
        return mx
    }
}