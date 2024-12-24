import kotlin.math.pow

class Solution3344 {
    private val dp = LongArray(2200)

    init {
        (1..<dp.lastIndex).forEach { i ->
            val sum = (0..<i).sumOf { i.or(it).toLong() }
            dp[i+1] = dp[i] + 2L*sum + i.toLong()
        }
    }

    fun maxSizedArray(s: Long): Int {
        var (l,r) = 1 to (s.toDouble().pow(0.22)).toInt() +1
        while (l<=r) {
            val m = (l+r)/2
            if (dp[m]*m.toLong()*(m.toLong()-1L)/2L <= s) l = m+1 else r = m-1
        }
        return r
    }
}
