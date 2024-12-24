class Solution1964 {
    fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
        val n = obstacles.size
        var len = 0
        val res = IntArray(n)
        val stk = IntArray(n)
        (0..<n).forEach { i ->
            var (l, r) = 0 to len
            while (l < r) {
                val m = (l+r)/2
                if (stk[m] <= obstacles[i]) l = m+1 else r = m
            }
            res[i] = l+1
            if (len == l) len++
            stk[l] = obstacles[i]
        }
        return res
    }
}
