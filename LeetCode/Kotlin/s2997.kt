class Solution2997 {
    fun minOperations(nums: IntArray, k: Int): Int = nums.fold(k, Int::xor).countOneBits()
}