class Solution2361 {
    fun minimumCosts(regular: IntArray, express: IntArray, expressCost: Int): LongArray {
        val n = regular.size
        var f = 0L
        var g = Int.MAX_VALUE/2.toLong()
        val cost = LongArray(n)
        for (i in 0..<n) {
            val a = regular[i].toLong()
            val b = express[i].toLong()
            val ff = minOf(f + a, g + a)
            val gg = minOf(f + expressCost + b, g + b)
            f = ff
            g = gg
            cost[i] = minOf(f, g)
        }
        return cost
    }
}