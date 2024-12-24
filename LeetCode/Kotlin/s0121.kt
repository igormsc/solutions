class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var x = 0
        return if (prices.size < 2) 0
                else (1..prices.lastIndex).maxOf { i ->
                            x = (x + prices[i] - prices[i - 1]).let{ if (it<0) 0 else it}
                            x }
    }
}
