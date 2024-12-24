class Solution2036 {
    fun maximumAlternatingSubarraySum(nums: IntArray): Long {
        var (res, f, g) = longArrayOf(Long.MIN_VALUE/2, Long.MIN_VALUE/2, Long.MIN_VALUE/2)
        for (x in nums) {
            val z = maxOf(g, 0L) + x.toLong()
            g = f - x
            f = z
            res = maxOf(res, f, g)
        }
        return res
    }

}