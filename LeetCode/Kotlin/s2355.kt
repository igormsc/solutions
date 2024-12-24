class Solution2355 {
    fun maximumBooks(books: IntArray): Long {
        val n = books.size
        val nums = IntArray(n)
        ( 0..<n).forEach { nums[it] = books[it] - it }
        val left = IntArray(n) {-1}
        val stk = mutableListOf<Int>()
        for (i in 0..<n) {
            while (stk.isNotEmpty() && nums[stk.last()] >= nums[i]) stk.removeLast()
            if (stk.isNotEmpty()) left[i] = stk.last()
            stk.add(i)
        }
        var res = 0L
        val dp = LongArray(n)
        dp[0] = books[0].toLong()
        for (i in 0..<n) {
            val j = left[i]
            val v = books[i]
            val cnt = minOf(v, (i - j))
            val u = v - cnt + 1
            val s = (u + v).toLong() * cnt / 2
            dp[i] = s + (if (j == -1) 0 else dp[j])
            res = maxOf(res, dp[i])
        }
        return res
    }

}