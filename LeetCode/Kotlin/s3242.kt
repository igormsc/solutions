class NeighborSum(grid: Array<IntArray>) {
    private val sAdj = IntArray(101)
    private val sDiag = IntArray(101)

    init {
        val dAdj= intArrayOf(0,1,0,-1,0)
        val dDiag = intArrayOf(1,1,-1,-1,1)
        fun add(i: Int, j: Int, v: Int, s: IntArray) {
            if (minOf(i,j) >= 0 && maxOf(i,j) < grid.size) s[grid[i][j]] += v
        }
        grid.indices.forEach { i ->
            grid.indices.forEach { j ->
                (0..3).forEach { d->
                    add(i+dAdj[d], j+dAdj[d+1], grid[i][j], sAdj)
                    add(i+dDiag[d], j+dDiag[d+1], grid[i][j], sDiag)
                }
            }
        }
    }

    fun adjacentSum(value: Int): Int = sAdj[value]

    fun diagonalSum(value: Int): Int = sDiag[value]

}
