class Solution1605 {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> =
        rowSum.indices.fold(Array(rowSum.size) { IntArray(colSum.size)}) { mx, i ->
            colSum.indices.forEach { j ->
                mx[i][j] = minOf(rowSum[i], colSum[j])
                rowSum[i] -= mx[i][j]
                colSum[j] -= mx[i][j]
            }; mx}
}
