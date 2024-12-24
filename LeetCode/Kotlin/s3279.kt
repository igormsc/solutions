import java.util.*

class Solution3279 {
    fun maxArea(height: Int, positions: IntArray, directions: String): Long {
        val delta: MutableMap<Int, Int> = TreeMap()
        var diff = 0
        var res = 0L
        for (i in positions.indices) {
            val pos = positions[i]
            val dir = directions[i]
            res += pos.toLong()
            if (dir == 'U') {
                diff++
                delta.merge(height - pos, -2) { a: Int, b: Int -> a+b }
                delta.merge(height * 2 - pos, 2) { a: Int, b: Int -> a+b }
            } else {
                diff--
                delta.merge(pos, 2) { a: Int, b: Int -> a+b }
                delta.merge(height + pos, -2) { a: Int, b: Int -> a+b }
            }
        }
        var r = res
        var pre = 0
        for ((cur, d) in delta) {
            res += (cur - pre).toLong() * diff
            pre = cur
            diff += d
            r = maxOf(r, res)
        }
        return r
    }

}