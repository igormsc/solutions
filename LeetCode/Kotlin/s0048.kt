class Solution048 {
    fun rotate(matrix: Array<IntArray>): Unit {
        var (l, r) = 0 to matrix.lastIndex
        while (l < r) {
            (0..<r - l).forEach { i ->
                matrix[l][l + i] = matrix[l + i][r].also { matrix[l + i][r] = matrix[l][l + i] }
                matrix[l][l + i] = matrix[r][r - i].also { matrix[r][r - i] = matrix[l][l + i] }
                matrix[l][l + i] = matrix[r - i][l].also { matrix[r - i][l] = matrix[l][l + i] }
            }
            l++
            r--
        }
    }
}