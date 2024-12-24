class Solution3269 {
    fun minLargest(nums1: IntArray, nums2: IntArray): Int {
        val (m,n) = nums1.size to nums2.size
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m)
            dp[i][0] = nxt(dp[i - 1][0], nums1[i - 1])
        for (j in 1..n)
            dp[0][j] = nxt(dp[0][j - 1], nums2[j - 1])
        for (i in 1..m)
            for (j in 1..n) {
                val x = nxt(dp[i - 1][j], nums1[i - 1])
                val y = nxt(dp[i][j - 1], nums2[j - 1])
                dp[i][j] = minOf(x,y)
            }
        return dp[m][n]
    }

    private fun nxt(x: Int, y: Int): Int = if ((x and 1 xor y) == 1) x + 1 else x + 2

}