import kotlin.math.absoluteValue

class Solution296 {
    fun minTotalDistance(grid: Array<IntArray>): Int {
        val rows = mutableListOf<Int>()
        val cols = mutableListOf<Int>()
        for (i in grid.indices)
            for (j in grid[0].indices)
                if (grid[i][j] == 1) {
                    rows.add(i)
                    cols.add(j)
                }
        cols.sort()
        val i = rows[rows.size shr 1]
        val j = cols[cols.size shr 1]

        fun f(arr: MutableList<Int>, x: Int): Int = arr.sumOf{ (it - x).absoluteValue }

        return f(rows, i) + f(cols, j)
    }

}