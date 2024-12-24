class Solution2345 {
    fun visibleMountains(peaks: Array<IntArray>): Int {
        val n = peaks.size
        val d = Array(n) { IntArray(2) }
        (0..<n).forEach {
            val (x, y) = peaks[it]
            d[it] = intArrayOf(x - y, x + y)
        }
        d.sortWith(compareBy<IntArray> { it[0] }.thenBy { -it[1] })
        var res = 0
        var mx = Int.MIN_VALUE
        for (i in 0..<n)
            if (d[i][1] > mx) {
                mx = d[i][1]
                if (!(i < n - 1 && d[i][0] == d[i + 1][0] && d[i][1] == d[i + 1][1])) res++
            }
        return res
    }

}