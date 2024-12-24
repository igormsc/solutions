class Solution1380 {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val n = matrix.size
        val m = matrix[0].size
        val rowMin = IntArray(n) {Int.MAX_VALUE}
        val colMax = IntArray(m) {Int.MIN_VALUE}
        (0..<n).forEach { i ->
            (0..<m).forEach { j ->
                if (rowMin[i] > matrix[i][j]) rowMin[i] = matrix[i][j]
                if (colMax[j] < matrix[i][j]) colMax[j] = matrix[i][j] } }
        val res = mutableListOf<Int>()
        (0..<n).forEach { i ->
            (0..<m).forEach { j ->
            if (rowMin[i] == matrix[i][j] && colMax[j] == matrix[i][j]) res.add(matrix[i][j]) } }
        return res
    }
}
