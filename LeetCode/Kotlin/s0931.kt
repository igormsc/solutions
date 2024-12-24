class Solution931 {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        (1..matrix.lastIndex).forEach { i ->
            matrix.indices.forEach { j ->
                matrix[i][j] += minOf(matrix[i-1][minOf(matrix.lastIndex, j+1)], minOf(matrix[i-1][maxOf(j-1, 0)], matrix[i-1][j])) } }
        return matrix.last().min()
    }
}