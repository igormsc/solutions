import java.util.*

class Solution3009 {
    fun maxIntersectionCount(y: IntArray): Int {
        val line = TreeMap<Int, Int>()
        val n = y.size
        var res = 0
        var cnt = 0

        for (i in 1..<n) {
            val start = 2 * y[i - 1]
            val end = 2 * y[i] + (if (i == n - 1) 0 else if (y[i] > y[i - 1]) -1 else 1)
            line.merge(minOf(start, end), 1) { a: Int, b: Int -> a+b }
            line.merge(maxOf(start, end) + 1, -1) { a: Int, b: Int -> a+b }
        }

        for (v in line.values) {
            cnt += v
            res = maxOf(res, cnt)
        }

        return res
    }

}