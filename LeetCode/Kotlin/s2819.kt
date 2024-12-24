import java.util.*

class Solution2819 {
    fun minimumRelativeLosses(prices: IntArray, queries: Array<IntArray>): LongArray {
        val n = prices.size
        prices.sort()
        val s = LongArray(n + 1)
        (0..<n).forEach { s[it + 1] = s[it] + prices[it] }
        val q = queries.size

        fun f(k: Int, m: Int): Int {
            var l = 0
            var r = Arrays.binarySearch(prices, k)
            if (r < 0) r = -(r + 1)
            r = minOf(m,r)
            while (l < r) {
                val mid = (l + r) shr 1
                val right = m - mid
                if (prices[mid] < 2L * k - prices[n - right]) l = mid + 1
                else r = mid
            }
            return l
        }

        val res = LongArray(q)
        for (i in 0..<q) {
            val (k,m) = queries[i]
            val l = f(k, m)
            val r = m - l
            res[i] = s[l] + 2L * k * r - (s[n] - s[n - r])
        }
        return res
    }

}
