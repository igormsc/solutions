class Solution3325 {
    fun numberOfSubstrings(s: String, k: Int): Int {
        val cnt = IntArray(255)
        val n = s.length
        var res = (n+1)*n/2
        var i = 0
        for (j in s.indices) {
            val c = s[j]
            cnt[c.code]++
            while (cnt[c.code] >= k) cnt[s[i++].code]--
            res -= j-i+1
        }
        return res
    }
}

fun numberOfSubstrings(s: String, k: Int): Int {
    val n = s.length
    var res = (n + 1) * n / 2
    val count = IntArray(26)
    var i = 0
    var j = 0
    while (j < n) {
        val c = s[j]
        count[c.code - 'a'.code]++
        while (count[c.code - 'a'.code] >= k) {
            val leftChar = s[i]
            count[leftChar.code - 'a'.code]--
            i++
        }
        res -= j - i + 1
        j++
    }
    return res
}