class Solution1153 {
    fun canConvert(str1: String, str2: String): Boolean {
        if (str1 == str2) return true
        var m = 0
        val cnt = IntArray('z'.code+1)
        val n = str1.length
        for (i in 0..<n) if (++cnt[str2[i].code] == 1) m++
        if (m == 26) return false
        val d = IntArray('z'.code+1)
        for (i in 0..<n) {
            val (a,b) = str1[i].code  to str2[i].code
            if (d[a] == 0) d[a] = b + 1
            else if (d[a] != b + 1) return false
        }
        return true
    }

}