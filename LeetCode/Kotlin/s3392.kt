class Solution3392 {
    fun countSubarrays(nums: IntArray): Int = (0..nums.lastIndex-2).count { nums[it+1] == 2*(nums[it]+nums[it+2]) }
}
