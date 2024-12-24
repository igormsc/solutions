class Solution469 {
    fun isConvex(points: List<List<Int>>): Boolean {
        val n = points.size
        var pre = 0L
        points.indices.forEach { i ->
            val (x1, y1) = points[(i + 1) % n][0] - points[i][0] to points[(i + 1) % n][1] - points[i][1]
            val (x2, y2) = points[(i + 2) % n][0] - points[i][0] to points[(i + 2) % n][1] - points[i][1]
            val cur = (x1 * y2 - x2 * y1).toLong()
            if (cur != 0L) {
                if (cur * pre < 0L) return false
                pre = cur
            }
        }
        return true
    }

}