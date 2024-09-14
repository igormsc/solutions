import java.util.*
import kotlin.math.pow

class Solution3272 {
    fun countGoodIntegers(n: Int, k: Int): Long {
        var res: Long = 0
        val begin = 10.0.pow(((n - 1) / 2)).toInt()
        val end = 10.0.pow(((n + 1) / 2)).toInt()

        val fct = LongArray(n + 1).also { it[0] = 1L }
        for (i in 1..n) fct[i] = i * fct[i - 1]

        val set = HashSet<String>()
        for (i in begin..<end) {
            val half = StringBuilder(i.toString())
            val plm = StringBuilder(half)

            if (n % 2 != 0) half.deleteCharAt(half.lastIndex)
            plm.append(half.reverse())
            if (plm.toString().toLong() % k == 0L) {
                val cs = plm.toString().toCharArray()
                cs.sort()
                set.add(String(cs))
            }
        }

        for (pldr in set) {
            val cnt = IntArray(10)
            for (p in pldr) cnt[p.code - '0'.code]++
            val m = n - cnt[0]
            var x = fct[m]
            for (i in 1..9) x /= fct[cnt[i]]
            x *= comb(n - 1, m - 1)
            res += x
        }
        return res
    }

    private fun comb(n: Int, k: Int): Long =
        when {
            k > n -> 0
            k == 0 || k == n -> 1
            else -> {
                val comb = Array(n + 1) { LongArray(k + 1) }
                (0..n).forEach { i ->
                    comb[i][0] = 1
                    var j = 1
                    while (j <= k && j <= i) comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j++]
                }
                comb[n][k]
            }
        }
}