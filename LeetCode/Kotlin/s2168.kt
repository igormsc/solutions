class Solution2168 {
    fun equalDigitFrequency(s: String): Int {
        val n = s.length
        val ps = Array(n + 1) { IntArray(10) }
        for (i in 0..<n) {
            ps[i + 1][s[i].code - '0'.code]++
            (0..9).forEach { ps[i + 1][it] += ps[i][it] }
        }

        fun chk(i: Int, j: Int): Boolean {
            val st = mutableSetOf<Int>()
            for (k in 0..9) {
                val cnt = ps[j + 1][k] - ps[i][k]
                if (cnt > 0) st.add(cnt)
                if (st.size > 1) return false
            }
            return true
        }

        val vis = mutableSetOf<String>()
        for (i in 0..<n)
            for (j in i..<n)
                if (chk(i, j)) vis.add(s.substring(i, j + 1))

        return vis.size
    }

}