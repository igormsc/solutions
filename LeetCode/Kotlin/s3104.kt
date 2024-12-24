class Solution3104 {
    fun maxSubstringLength(s: String): Int {
        val first = IntArray('z'.code+1) {-1}
        val last = IntArray('z'.code+1)
        val n = s.length
        for (i in 0..<n) {
            val j = s[i].code
            if (first[j] == -1) first[j] = i
            last[j] = i
        }
        var res = -1
        for (k in 'a'.code..'z'.code) {
            val i = first[k]
            if (i == -1) continue
            var mx = last[k]
            for (j in i..<n) {
                val a = first[s[j].code]
                val b = last[s[j].code]
                if (a < i) break
                mx = maxOf(mx, b)
                if (mx == j && j - i + 1 < n)
                    res = maxOf(res, j - i + 1)
            }
        }
        return res
    }

}