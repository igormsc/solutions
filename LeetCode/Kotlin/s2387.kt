class Solution2387 {
    fun matrixMedian(grid: Array<IntArray>): Int {
        val (m,n) = grid.size to grid[0].size
        val target = (m * n + 1) shr 1

        fun cnt(x: Int): Int {
            var cnt = 0
            for (row in grid) {
                var (l,r) = 0 to row.size
                while (l < r) {
                    val mid = (l + r) shr 1
                    if (row[mid] > x) r = mid
                    else l = mid + 1
                }
                cnt += l
            }
            return cnt
        }

        var (l, r) = 0 to 1000010
        while (l < r) {
            val mid = (l + r) shr 1
            if (cnt(mid) >= target) r = mid
            else l = mid + 1
        }
        return l
    }

}