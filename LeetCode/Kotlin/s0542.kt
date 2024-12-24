class Solution542 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val (m,n) = mat.size to mat[0].size
        mat.indices.forEach { i ->
            mat[0].indices.forEach { j ->
                if (mat[i][j] != 0) {
                    val a = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
                    if (i != 0) a[0] = mat[i-1][j]
                    if (j != 0) a[1] = mat[i][j-1]
                    mat[i][j] = a.min()
                    if (mat[i][j] != Int.MAX_VALUE) mat[i][j]++
                }
            }
        }

        (mat.lastIndex downTo 0).forEach { i ->
            (mat[0].lastIndex downTo 0).forEach { j ->
                if (mat[i][j] != 0) {
                    val a = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)
                    if (i != 0) a[0] = mat[i - 1][j]
                    if (j != 0) a[1] = mat[i][j - 1]
                    if (i != m - 1) a[2] = mat[i + 1][j]
                    if (j != n - 1) a[3] = mat[i][j + 1]
                    mat[i][j] = a.min()
                    if (mat[i][j] != Int.MAX_VALUE) mat[i][j]++
                }
            }
        }
        return mat
    }

}
