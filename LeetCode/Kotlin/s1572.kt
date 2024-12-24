class Solution1572 {
    fun diagonalSum(mat: Array<IntArray>): Int = mat.indices.sumOf { mat[it][it] + if (it==mat.lastIndex-it) 0 else mat[it][mat.lastIndex-it] }
}