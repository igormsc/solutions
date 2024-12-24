class Solution3379 {
    fun constructTransformedArray(nums: IntArray): IntArray = nums.mapIndexed { i, n -> nums[(i+n%nums.size + nums.size)%nums.size] }.toIntArray()
}
