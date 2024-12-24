import java.util.*

class Solution367 {
    fun betterCompression(compressed: String): String {
        val cnt: MutableMap<Char, Int> = TreeMap()
        var i = 0
        val n = compressed.length
        while (i < n) {
            val c = compressed[i]
            var j = i + 1
            var x = 0
            while (j < n && compressed[j].isDigit()) {
                x = x * 10 + (compressed[j].code - '0'.code)
                j++
            }
            cnt.merge(c, x) { a: Int, b: Int -> a+b }
            i = j
        }
        val sb = StringBuilder()
        for ((k, v) in cnt)
            sb.append(k).append(v)
        return sb.toString()
    }

}