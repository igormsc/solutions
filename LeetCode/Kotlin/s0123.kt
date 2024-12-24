class Solution123 {
    fun maxProfit(prices: IntArray): Int {
        var (h1, h2) = Int.MIN_VALUE to Int.MIN_VALUE
        var (r1, r2) = 0 to 0
        prices.forEach { p ->
            r2 = maxOf(r2, h2+p)
            h2 = maxOf(h2, r1-p)
            r1 = maxOf(r1, h1+p)
            h1 = maxOf(h1, -p)
        }
        return r2
    }
}
