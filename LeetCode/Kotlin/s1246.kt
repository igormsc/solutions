class Solution1246 {
    fun minimumMoves(arr: IntArray): Int {
        val n = arr.size
        val f = Array(n) { IntArray(n) }
        (0..<n).forEach { f[it][it] = 1 }
        for (i in n - 2 downTo 0) {
            for (j in i + 1..<n) {
                if (i + 1 == j) f[i][j] = if (arr[i] == arr[j]) 1 else 2
                else {
                    var t = if (arr[i] == arr[j]) f[i + 1][j - 1] else Int.MAX_VALUE/2
                    for (k in i..<j)
                        t = minOf(t, f[i][k] + f[k + 1][j])
                    f[i][j] = t
                }
            }
        }
        return f[0][n - 1]
    }

}