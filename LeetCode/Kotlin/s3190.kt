class Solution3190 {
    fun minimumOperations(nums: IntArray): Int = nums.count { it % 3 != 0 }
}
