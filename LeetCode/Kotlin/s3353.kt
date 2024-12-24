class Solution3353 {
    fun minOperations(nums: IntArray): Int = (1..nums.lastIndex).count { nums[it-1] != nums[it] }
}