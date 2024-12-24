class Solution1351 {
    fun countNegatives(grid: Array<IntArray>): Int {
        val (n, m) = grid.size to grid[0].size
        var res = 0
        var last = m-1
        (0..<n).forEach { row ->
            if (grid[row][0] < 0) res += m
            else {
                if (grid[row].last() <= 0) {
                    var (l, r) = 0 to last
                    while (l <= r) {
                        val mid = l + (r-l)/2
                        if (grid[row][mid] < 0) r = mid-1 else l = mid+1
                    }
                    res += m - l
                    last = l
                }
            }
        }
        return res
    }
}
