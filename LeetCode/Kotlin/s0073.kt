class Solution073 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix[0].size
        val fCol = BooleanArray(m)
        matrix.indices.forEach { i ->
            var fRow = false
            matrix[0].indices.forEach { j ->
                if (matrix[i][j] == 0) {
                    fCol[j] = true
                    fRow = true
                }
            }
            if (fRow) matrix[i].indices.forEach { matrix[i][it] = 0 }
        }
        for (k in matrix[0].indices)
            if (fCol[k]) matrix.indices.forEach { matrix[it][k] = 0 }
    }
}