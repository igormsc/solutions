class Solution1035 {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val (m, n) = nums1.size to nums2.size
        if (m<n) return maxUncrossedLines(nums2, nums1)
        val dp = IntArray(n + 1)
        (0..<m).forEach { i ->
            var (j, prev) = intArrayOf(-1, 0)
            while (++j < n) {
                val cur = dp[j+1]
                if (nums1[i] == nums2[j]) dp[j+1] = prev+1
                else if (dp[j]>dp[j+1]) dp[j+1] = dp[j]
                prev = cur
            }
        }
        return dp[n]
    }
}
