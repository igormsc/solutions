class Solution1314 {
    fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
        val (n, m) = mat.size to mat[0].size
        val res = Array(n) { IntArray(m) }
        (1..<n).forEach { mat[it][0] += mat[it-1][0] }
        (1..<m).forEach { mat[0][it] += mat[0][it-1] }
        (1..<n).forEach { r ->
            (1..<m).forEach { c -> mat[r][c] += mat[r-1][c] + mat[r][c-1] - mat[r-1][c-1] }
        }
        (0..<n).forEach { i ->
            (0..<m).forEach { j ->
                val mxR = minOf(i+k, n-1)
                val mxC = minOf(j+k, m-1)
                res[i][j] = when {
                    i>k && j>k -> mat[mxR][mxC] + mat[i-k-1][j-k-1] - mat[mxR][j-k-1] - mat[i-k-1][mxC]
                    i > k -> mat[mxR][mxC] - mat[i-k-1][mxC]
                    j > k -> mat[mxR][mxC] - mat[mxR][j-k-1]
                    else -> mat[mxR][mxC]
                }
            }
        }
        return res
    }
}
