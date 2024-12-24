class Solution750 {
    fun countCornerRectangles(grid: Array<IntArray>): Int {
        val n = grid[0].size
        var res = 0
        val cnt = mutableMapOf<List<Int>, Int>()
        for (row in grid)
            for (i in 0..<n)
                if (row[i] == 1)
                    for (j in i + 1..<n)
                        if (row[j] == 1) {
                            val t = listOf(i, j)
                            res += cnt[t]?:0
                            cnt.merge(t, 1) { a: Int?, b: Int? -> Integer.sum(a!!,b!!) }
                        }
        return res
    }
}