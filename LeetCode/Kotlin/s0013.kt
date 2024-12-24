class Solution013 {
    fun romanToInt(s: String): Int {
        val rmn = "IVXLCDM"
        val rval = intArrayOf(1, 5, 10, 50, 100, 500, 1000)
        val d = mutableMapOf<Char, Int>()
        rval.indices.forEach { d[rmn[it]] = rval[it] }
        val n = s.length
        var res = d[s[n - 1]]!!
        for (i in 0..<s.lastIndex) {
            val sign = if (d[s[i]]!! < d[s[i + 1]]!!) -1 else 1
            res += sign * d[s[i]]!!
        }
        return res
    }
}