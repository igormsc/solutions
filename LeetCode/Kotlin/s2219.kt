class Solution2219 {
    fun maximumSumScore(nums: IntArray): Long {
        val n = nums.size
        val s = LongArray(n + 1)
        nums.indices.forEach { s[it + 1] = s[it] + nums[it] }
        return nums.indices.fold(Long.MIN_VALUE) { r, i -> maxOf(r, s[i + 1], s[n] - s[i]) }
    }

}