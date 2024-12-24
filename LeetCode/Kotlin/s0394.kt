class Solution394 {
    fun decodeString(s: String): String {
        var i = 0
        fun decode(): String {
            val res = StringBuilder()
            while (i < s.length && s[i] != ']') {
                if (!s[i].isDigit()) res.append(s[i++])
                else {
                    var n = 0
                    while (i < s.length && s[i].isDigit()) n = n * 10 + (s[i++].code - '0'.code)
                    i++
                    val t = decode()
                    i++
                    while (n-- > 0) res.append(t)
                }
            }
            return res.toString()
        }
        return decode()
    }
}
