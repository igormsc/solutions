class Solution1802 {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        var (l, r) = 1 to maxSum

        fun sum(x: Long, cnt: Int): Long = if (x >= cnt) (x + x - cnt + 1) * cnt / 2 else (x + 1) * x / 2 + cnt - x

        while (l < r) {
            val m = (l + r + 1) / 2
            if (sum((m - 1).toLong(), index) + sum(m.toLong(), n - index) <= maxSum) l = m else r = m - 1
        }
        return l
    }

}
