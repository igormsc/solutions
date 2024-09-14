class Solution264 {
    fun nthUglyNumber(n: Int): Int =
        when {
            n <= 0 -> 0
            n == 1 -> 1
            else -> {
                var t2 = 0
                var t3 = 0
                var t5 = 0
                val k = IntArray(n).also { it[0] = 1 }
                (1..<n).forEach { i ->
                    k[i] = minOf(2 * k[t2], 3 * k[t3], 5 * k[t5])
                    if (k[i] == 2 * k[t2]) t2++
                    if (k[i] == 3 * k[t3]) t3++
                    if (k[i] == 5 * k[t5]) t5++
                }
                k[n - 1]
            }
        }
}