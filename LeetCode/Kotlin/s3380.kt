class Solution3380 {
    fun maxRectangleArea(points: Array<IntArray>): Int {
        var res = -1
        val n = points.lastIndex
        points.sortWith( compareBy({ it[0] }, { it[1] }) )
        val rp = Array(4){IntArray(2)}
        (0..<n).forEach{ i ->
            rp[0] = intArrayOf(points[i][0], points[i][1])
            rp[1] = intArrayOf(points[i + 1][0], points[i + 1][1])
            var j = i+2
            while (j < n-1)
                if (points[j][1] > points[i + 1][1] || points[j][1] < points[i][1]) j++ else break
            if (j < n) {
                rp[2] = intArrayOf(points[j][0], points[j][1])
                rp[3] = intArrayOf(points[j + 1][0], points[j + 1][1])
                res = maxOf(res, if (rp[0][0] == rp[1][0] && rp[2][0] == rp[3][0] && rp[0][1] == rp[2][1] && rp[1][1] == rp[3][1]) (rp[2][0] - rp[0][0]) * (rp[1][1] - rp[0][1]) else -1)
            }
        }
        return res
    }

}
