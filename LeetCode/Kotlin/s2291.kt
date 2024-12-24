class Solution2291 {
    fun maximumProfit(present: IntArray, future: IntArray, budget: Int): Int {
        val d = IntArray(budget + 1)
        present.indices.forEach { i ->
            val p = present[i]
            for (j in budget downTo p)
                d[j] = maxOf(d[j], d[j - p] + future[i] - p)
        }
        return d[budget]
    }

}