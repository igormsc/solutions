class Solution3375 {
    fun minOperations(nums: IntArray, k: Int): Int = nums.toSet().count { x -> x > k.also {if (x < k) return -1} }
}
