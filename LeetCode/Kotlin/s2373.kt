class Solution2373 {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> =
        (0..grid.size - 3).fold(Array(grid.size - 2) { IntArray(grid.size - 2) }) { r, i ->
            (0..grid.size - 3).forEach { j ->
                r[i][j] = maxOf(r[i][j], grid.slice(i..<i + 3).maxOf { r -> r.slice(j..<j + 3).max() })
            }
            r
        }

}
