class Solution2229 {
    fun isConsecutive(nums: IntArray): Boolean = nums.toSet().size == nums.size && nums.max() == nums.min() + nums.lastIndex
}