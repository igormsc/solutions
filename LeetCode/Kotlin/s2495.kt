class Solution2495 {
    fun evenProduct(nums: IntArray): Long {
        var x = -1
        return nums.indices.sumOf { if (nums[it] % 2 == 0) x = it
                                    (x + 1).toLong() }
    }

}