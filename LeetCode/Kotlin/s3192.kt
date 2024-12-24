class Solution3192 {
    fun minOperations(nums: IntArray): Int = nums.fold(0) { r, n -> r + if ((r+n)%2 == 0) 1 else 0 }
}
