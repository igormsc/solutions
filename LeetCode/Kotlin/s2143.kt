class Solution2143 {
    fun countSubranges(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val s1 = nums1.sum()
        val s2 = nums2.sum()
        val f = Array(n) { IntArray(s1 + s2 + 1) }
        var res = 0
        val MOD = 1_000_000_007
        for (i in 0..<n) {
            val (a,b) = nums1[i] to nums2[i]
            f[i][a + s2]++
            f[i][-b + s2]++
            if (i > 0)
                for (j in 0..s1 + s2) {
                    if (j >= a) f[i][j] = (f[i][j] + f[i - 1][j - a]) % MOD
                    if (j + b <= s1 + s2) f[i][j] = (f[i][j] + f[i - 1][j + b]) % MOD
                }
            res = (res + f[i][s2]) % MOD
        }
        return res
    }

}