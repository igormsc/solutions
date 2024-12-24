class Solution3144 {
    fun minimumSubstringsInPartition(s: String): Int {
        val dp = IntArray(s.length + 1){s.length}.also { it[it.lastIndex] = 0 }
        (s.lastIndex downTo 0).forEach { i ->
            val cnt = IntArray(26)
            var unq = 0
            var maxCnt = 0
            var sz = 1
            while (i+sz <= s.length) {
                cnt[s[i + sz - 1].code - 'a'.code]++
                if (cnt[s[i + sz - 1].code - 'a'.code] == 1) unq++
                maxCnt = maxOf(maxCnt, cnt[s[i + sz - 1].code - 'a'.code]);
                if (sz == unq * maxCnt) dp[i] = minOf(dp[i], 1 + dp[i + sz]);
                sz++
            }
        }
        return dp[0];
    }
}
