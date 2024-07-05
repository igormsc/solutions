class Solution1289 {
    fun minFallingPathSum(grid: Array<IntArray>): Int =
        grid.fold(Triple(0,0,-1)) { t, row ->
            row.foldIndexed(Triple(Int.MAX_VALUE, Int.MAX_VALUE, -1))  { j, x, g ->
                val z = if (j != t.third) t.first else t.second
                if (g + z < x.first) Triple(g+z, x.first, j) else Triple(x.first, minOf(x.second, g + z), x.third) } }.first

}


