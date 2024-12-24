class Solution3158 {
    fun duplicateNumbersXOR(nums: IntArray): Int = nums.fold(nums.toSet().reduce(Int::xor),Int::xor)
}
