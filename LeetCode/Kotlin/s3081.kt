fun main() {
    val sl = Solution3081()

    var s = "???"

    println(sl.minimizeStringValue(s))


}


class Solution3081 {
    fun minimizeStringValue(s: String): String {
        val n = s.length
        val frq = s.fold(IntArray(26)) { f, c -> if (c != '?') f[c.code - 'a'.code]++; f }
        val chs = mutableListOf<Char>()
        (0..<n).forEach { i ->
            if (s[i] == '?')
                (0..25).fold(0) { m, j -> if (frq[j] < frq[m]) j else m }.also { q ->
                    chs.add((q + 'a'.code).toChar())
                    frq[q]++
                }
        }
        chs.sort()
        var j = 0
        return (0..<n).fold(StringBuilder()) { sb, i ->
            sb.append(if (s[i] == '?') chs[j++] else s[i])
            sb
        }.toString()
    }

}

