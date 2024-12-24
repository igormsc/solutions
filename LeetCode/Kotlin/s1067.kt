class Solution1067 {
    fun digitsCount(d: Int, low: Int, high: Int): Int {

        fun cnt(d: Int, n: Int): Int {
            if (n < 0 || n < d) return 0
            var res = 0L
            var i = 1L
            val n = n.toLong()
            val d = d.toLong()
            while (i <= n) {
                val x = i * 10L
                res += (n / x) * i
                if (d > 0L)
                    res += minOf(maxOf(n % x - d * i + 1L, 0L), i)
                else if (n / x > 0L && i > 1L)
                    res += minOf(n % x + 1L, i) - i
                i *= 10L
            }
            return res.toInt()
        }

        return cnt(d, high) - cnt(d, low - 1)
    }

}
