class Solution2955 {
    fun sameEndSubstringCount(s: String, queries: Array<IntArray>): IntArray {
        val n = s.length
        val cnt = Array('z'.code+1) { IntArray(n + 1) }
        for (j in 1..n) {
            for (i in 'a'.code..'z'.code)
                cnt[i][j] = cnt[i][j - 1]
            cnt[s[j - 1].code][j]++
        }
        val res = IntArray(queries.size)
        for (k in queries.indices) {
            val l = queries[k][0]
            val r = queries[k][1]
            res[k] = r - l + 1
            for (i in 'a'.code..'z'.code) {
                val x = cnt[i][r + 1] - cnt[i][l]
                res[k] += x * (x - 1) / 2
            }
        }
        return res
    }
}