class Solution1182 {
    fun shortestDistanceColor(colors: IntArray, queries: Array<IntArray>): List<Int> {
        val n = colors.size
        val right = Array(n + 1) { IntArray(3) {Int.MAX_VALUE/2} }
        for (i in n - 1 downTo 0) {
            for (j in 0..2)
                right[i][j] = right[i + 1][j]
            right[i][colors[i] - 1] = i
        }
        val left = Array(n + 1) { IntArray(3) { Int.MIN_VALUE/2} }
        for (i in 1..n) {
            for (j in 0..2)
                left[i][j] = left[i - 1][j]
            left[i][colors[i - 1] - 1] = i - 1
        }
        val res = mutableListOf<Int>()
        for (q in queries) {
            val i = q[0]
            val c = q[1] - 1
            val d = minOf(i - left[i + 1][c],right[i][c] - i)
            res.add(if (d > n) -1 else d)
        }
        return res
    }

}