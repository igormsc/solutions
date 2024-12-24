class NumMatrix(matrix: Array<IntArray>) {
    private val matrix = matrix
    private val sumCols = (1..matrix.size).fold(Array(matrix.size+1) {IntArray(matrix[0].size)}) { r, i ->
                            matrix[0].indices.forEach { j -> r[i][j] = r[i - 1][j] + matrix[i - 1][j] }; r }

    fun update(row: Int, col: Int, `val`: Int) {
        for (i in row + 1..sumCols.lastIndex)
            sumCols[i][col] = sumCols[i][col] - matrix[row][col] + `val`
        matrix[row][col] = `val`
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
        (col1..col2).sumOf { sumCols[row2 + 1][it] - sumCols[row1][it] }
}
