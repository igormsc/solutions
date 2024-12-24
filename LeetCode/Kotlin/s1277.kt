class Solution1277 {
    fun countSquares(matrix: Array<IntArray>): Int =
        matrix.indices.sumOf { i ->
            matrix[0].indices.sumOf { j ->
                if (matrix[i][j] > 0 && i > 0 && j > 0) matrix[i][j] = minOf(matrix[i - 1][j - 1], minOf(matrix[i - 1][j], matrix[i][j - 1])) + 1
                matrix[i][j]
            }
        }
}
