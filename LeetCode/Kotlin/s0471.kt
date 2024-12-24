class Solution471 {
    fun encode(s: String): String {
        val n = s.length
        val f = Array(n) { Array(n) {""} }

        fun g(i: Int, j: Int): String {
            val t = s.substring(i, j + 1)
            if (t.length < 5) return t
            val k = (t + t).indexOf(t, 1)
            if (k < t.length) {
                val cnt = t.length / k
                return String.format("%d[%s]", cnt, f[i][i + k - 1])
            }
            return t
        }

        for (i in s.lastIndex downTo 0)
            for (j in i..s.lastIndex) {
                f[i][j] = g(i, j)
                if (j - i + 1 > 4)
                    for (k in i..<j) {
                        val t = f[i][k] + f[k + 1][j]
                        if (f[i][j]!!.length > t.length) f[i][j] = t
                    }
            }
        return f[0][n - 1]
    }

}