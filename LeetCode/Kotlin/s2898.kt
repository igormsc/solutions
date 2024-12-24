class Solution2898 {
    fun maxScore(prices: IntArray): Long {
        val cnt = mutableMapOf<Int, Long>()
        for (i in prices.indices)
            cnt.merge(prices[i] - i, prices[i].toLong()) { a: Long, b: Long -> a+b }
        return cnt.values.max()
    }

}