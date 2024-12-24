class Solution3153 {
    fun sumDigitDifferences(nums: IntArray): Long {
        val n = nums.size.toLong()
        val m = nums[0].toString().length
        val cnt = Array(m) {IntArray(10)}
        var res = n * (n-1) / 2L * m.toLong()
        for (n in nums) {
            var i = 0
            var n = n
            while (i<m && n>0) {
                res -= cnt[i++][n%10]++.toLong()
                n /= 10
            }
        }
        return res
    }
}
