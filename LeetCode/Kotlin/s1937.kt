class Solution1937 {
    fun maxPoints(points: Array<IntArray>): Long {
        var cur = LongArray(points[0].size)
        var prev = LongArray(points[0].size)
        points.forEach{ row ->
            var mx = 0L
            row.indices.forEach {
                mx = maxOf(mx-1, prev[it])
                cur[it] = mx
            }
            mx = 0L
            (row.lastIndex downTo 0).forEach {
                mx = maxOf(mx-1, prev[it])
                cur[it] = maxOf(cur[it], mx) + row[it].toLong()
            }
            cur = prev.also{prev = cur}
        }
        return prev.max()
    }
}
