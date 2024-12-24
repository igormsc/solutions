class Solution1131 {
    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        val n = arr1.size
        val dirs = intArrayOf(-1,1)
        var res = 0
        dirs.forEach { p ->
            dirs.forEach { q ->
                var min = p*arr1[0] + q*arr2[0]
                (1..<n).forEach { i ->
                    val cur = p*arr1[i] + q*arr2[i] + i
                    res = maxOf(cur - min, res)
                    min = minOf(min, cur)
                }
            }
        }
        return res
    }
}
