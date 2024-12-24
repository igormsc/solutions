class Solution411 {

    fun minAbbreviation(target: String, dictionary: Array<String>): String {
        val n = target.length
        val dict = dictionary.filter { o: String -> o.length == n }
        val res = Array(n) {""}

        fun chk(s: String): String {
            for (d in dict) {
                var flg = true
                var (i, j) = 0 to 0
                while (i < s.length) {
                    if (s[i].isDigit()) {
                        val y = if (i == s.lastIndex || !Character.isDigit(s[i + 1])) i else i + 1
                        j += s.substring(i, y + 1).toInt()
                        i = y
                    } else if (s[i] == d[j]) j++
                         else {
                                flg = false
                                break
                         }
                    i++
                }
                if (flg) return ""
            }
            return s
        }

        fun fn(j: Int, len: Int, mxLen: Int, q: Int, target: String, sb: StringBuilder): String {
            if (len + n - j < mxLen || len > mxLen) return ""
            if (j == n) return chk(sb.toString())
            val sz = sb.length
            for (i in j..<n) {
                var r = ""
                if (q == 0) {
                    sb.append(target.substring(j, i + 1))
                    r = fn(i + 1, len + i - j + 1, mxLen, 1, target, sb)
                } else {
                    sb.append(i - j + 1)
                    r = fn(i + 1, len + 1, mxLen, q xor 1, target, sb)
                }
                if (r.isNotEmpty()) return r
                sb.setLength(sz)
            }
            return ""
        }

        var (l, h) = 1 to  n
        while (l < h) {
            val mid = (l + h) / 2
            for (q in intArrayOf(0, 1)) if (res[mid].isEmpty())
                res[mid] = fn(0, 0, mid, q, target, StringBuilder())
            if (res[mid].isNotEmpty()) h = mid
            else l = mid + 1
        }
        return if (l == n) target else res[l]
    }

}