class Solution3387 {
    fun maxAmount(initialCurrency: String, pairs1: List<List<String>>, rates1: DoubleArray, pairs2: List<List<String>>, rates2: DoubleArray): Double {
        val res = mutableMapOf(initialCurrency to 1.0)
        fun bellman(pairs: List<List<String>>, rates: DoubleArray) {
            repeat(pairs.size) {
                pairs.indices.forEach { i ->
                    res[pairs[i][1]] = maxOf(res[pairs[i][1]]?:0.0, (res[pairs[i][0]]?:0.0) * rates[i])
                    res[pairs[i][0]] = maxOf(res[pairs[i][0]]?:0.0, (res[pairs[i][1]]?:0.0) / rates[i])
                } }
        }
        bellman(pairs1, rates1)
        bellman(pairs2, rates2)
        return res[initialCurrency]!!
    }
}
