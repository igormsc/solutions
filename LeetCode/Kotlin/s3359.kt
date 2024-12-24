class Solution3359 {
    fun countSubmatrices(grid: Array<IntArray>, k: Int): Long {
        val (m, n) = grid.size to grid[0].size
        var res = 0L
        val stk = Array(n) {mutableListOf<IntArray>()}
        val sum = IntArray(n)
        (0..<m).forEach { i ->
            var l = 0
            (0..<n).forEach { j ->
                if (grid[i][j] <= k) {
                    l = 1 + if (j > 0 && grid[i][j - 1] >= grid[i][j]) l else 0
                    var cnt = 1
                    while (stk[j].isNotEmpty() && stk[j].last()[0] > l) {
                        cnt += stk[j].last()[1]
                        sum[j] -= stk[j].last()[0] * stk[j].last()[1]
                        stk[j].removeLast()
                    }
                    if (stk[j].isEmpty() || stk[j].last()[0] != l) stk[j].add(intArrayOf(l,0))
                    stk[j][stk[j].lastIndex][1] += cnt
                    sum[j] += l * cnt
                    res += sum[j].toLong()
                } else {
                    l = 0
                    sum[j] = 0
                    stk[j].clear()
                }
            }
        }
        return res
    }
}
