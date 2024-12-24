class Solution136 {
    fun singleNumber(nums: IntArray): Int = nums.fold(0) { r, n -> r.xor(n)}
}
