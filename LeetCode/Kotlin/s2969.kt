class Solution2969 {
    fun minimumCoins(prices: IntArray): Int {
        val n = prices.size
        val q = mutableListOf<Int>()
        for (i in n downTo 1) {
            while (q.isNotEmpty() && q.first() > i * 2 + 1) q.removeFirst()
            if (i <= (n - 1) / 2) prices[i - 1] += prices[q.first() - 1]
            while (q.isNotEmpty() && prices[q.last() - 1] >= prices[i - 1]) q.removeLast()
            q.add(i)
        }
        return prices[0]
    }

}