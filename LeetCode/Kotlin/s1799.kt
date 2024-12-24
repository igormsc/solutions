class Solution1799 {
    fun maxScore(nums: IntArray): Int {
        val dp = Array(8) { IntArray(2.shl(15)) }

        fun f(i: Int, m: Int): Int {
            if (i > nums.size/2) return 0
            if (dp[i][m] == 0)
                nums.indices.forEach { j ->
                    (j+1..nums.lastIndex).forEach { k ->
                        val x = 1.shl(j) + 1.shl(k)
                        if (m.and(x) == 0) dp[i][m] = maxOf(dp[i][m], i * gcd(nums[j], nums[k]) + f(i+1, m+x)) } }
            return dp[i][m]
        }

        return f(1,0)
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
