class Solution567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var start = 0
        var cnt = 0
        val c = IntArray(255)
        s1.forEach { c[it.code]++ }
        var i = 0
        while (i<s2.length && cnt < s1.length) {
            if (c[s2[i].code] > 0) c[s2[i].code]-- .also {cnt++}
            else {
                while (s2[start] != s2[i]) {
                    c[s2[start].code]++
                    start++
                    cnt--
                }
                start++
            }
            i++
        }
        return cnt == s1.length
    }
}
