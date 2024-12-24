class Solution1272 {
    fun removeInterval(intervals: Array<IntArray>, toBeRemoved: IntArray): List<List<Int>> {
        val (x, y) = toBeRemoved
        val res = mutableListOf<List<Int>>()
        intervals.forEach { (u, v) ->
            if (u >= y || v <= x) res.add(listOf(u, v))
            else {
                if (u < x) res.add(listOf(u, x))
                if (v > y) res.add(listOf(y, v))
            }
        }
        return res
    }
}
