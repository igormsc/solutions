class Solution163 {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
        val n = nums.size
        if (n == 0) return listOf(listOf(lower, upper))
        val res = mutableListOf<List<Int>>()
        if (nums[0] > lower) res.add(listOf(lower, nums[0] - 1))
        for (i in 1..<n)
            if (nums[i] - nums[i - 1] > 1) res.add(listOf(nums[i - 1] + 1, nums[i] - 1))
        if (nums[n - 1] < upper) res.add(listOf(nums[n - 1] + 1, upper))

        return res
    }
}