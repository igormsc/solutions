class Solution1180 {
    fun countLetters(s: String): Int {
        var i = 0
        var res = 0
        val n = s.length
        while (i < n) {
            var j = i
            var cnt = 0
            while (j < n && s[j] == s[i]) {
                j++
                res += ++cnt
            }
            i = j
        }
        return res
    }

}