class Solution555 {
    fun splitLoopedString(strs: Array<String>): String {
        val n = strs.size
        for (i in strs.indices) {
            val s = strs[i]
            val t = StringBuilder(s).reverse().toString()
            if (s < t) strs[i] = t
        }
        var res = ""
        for (i in strs.indices) {
            val s = strs[i]
            val sb = StringBuilder()
            for (j in i + 1..<n) sb.append(strs[j])
            for (j in 0..<i) sb.append(strs[j])

            val t = sb.toString()
            for (j in s.indices) {
                val (a, b) = s.substring(j) to s.substring(0, j)
                var cur = a + t + b
                if (res < cur) res = cur
                cur = StringBuilder(b).reverse().append(t).append(StringBuilder(a).reverse().toString()).toString()
                if (res < cur) res = cur
            }
        }
        return res
    }

}