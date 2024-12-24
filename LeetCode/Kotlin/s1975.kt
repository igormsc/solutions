import kotlin.math.absoluteValue

class Solution1975 {

    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum = 0L
        var (z, ng) = intArrayOf(0,0)
        var min = Int.MAX_VALUE
        matrix.indices.forEach { i ->
            matrix[i].indices.forEach { j ->
                sum += matrix[i][j].toLong().absoluteValue
                if (matrix[i][j] == 0) z++
                if (matrix[i][j] < 0) ng++
                min = minOf(min, matrix[i][j].absoluteValue)
            }
        }
        return sum - if (z != 0 || ng.and(1) == 0) 0L else (2L*min.toLong())
    }

}
