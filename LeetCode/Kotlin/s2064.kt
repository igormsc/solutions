class Solution2064 {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        var (l, r) = 1 to 100_000
        while (l<r) {
            val m = (l + r) / 2
            if (quantities.sumOf { (it + m -1)/m } > n) l = m+1 else r = m
        }
        return l
    }
}
