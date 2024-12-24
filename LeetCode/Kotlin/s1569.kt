class Solution1569 {


    fun numOfWays(nums: IntArray): Int {
        val mod  = 1_000_000_007L
        val dp = Array(1001) { LongArray(1001) }.also{it[0][0]=1L}
        (1..nums.size).forEach { i ->
            dp[i][0] = 1
            dp[i][i] = 1
            (1..<i).forEach { dp[i][it] = (dp[i - 1][it - 1] + dp[i - 1][it]) % mod } }

        fun fs(l: List<Int>): Long =
            if (l.size <= 1) 1L else {
            val (d, u) = mutableListOf<Int>() to mutableListOf<Int>()
            (1..l.lastIndex).forEach { if (l[it] < l[0]) d.add(l[it]) else u.add(l[it])}
            ((fs(d) * fs(u)) % mod) * dp[l.size-1][d.size] % mod }

        return fs(nums.toMutableList()).toInt() - 1
    }

}
