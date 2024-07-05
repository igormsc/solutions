class Solution1509 {
    fun minDifference(nums: IntArray): Int  = if (nums.size<5)  0 else {
        val n = nums.size
        nums.sort()
        intArrayOf(nums[n - 1] - nums[3], nums[n - 2] - nums[2], nums[n - 3] - nums[1], nums[n - 4] - nums[0]).min() }
}