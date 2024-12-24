import java.util.*

class Solution269 {
    fun alienOrder(words: Array<String>): String {
        var cnt = 0
        val s = BooleanArray(26)
        val g = Array(26) { BooleanArray(26) }
        for (i in 0..<words.lastIndex) {
            for (c in words[i].toCharArray()) {
                if (cnt == 26) break
                val c = c.code - 'a'.code
                if (!s[c]) {
                    cnt++
                    s[c] = true
                }
            }
            for (j in words[i].indices) {
                if (j >= words[i + 1].length) return ""
                val c1 = words[i][j]
                val c2 = words[i + 1][j]
                if (c1 == c2) continue
                if (g[c2.code - 'a'.code][c1.code - 'a'.code]) return ""
                g[c1.code - 'a'.code][c2.code - 'a'.code] = true
                break
            }
        }
        for (c in words.last().toCharArray()) {
            if (cnt == 26) break
            val c = c.code - 'a'.code
            if (!s[c]) {
                cnt++
                s[c] = true
            }
        }

        val indegree = IntArray(26)
        for (i in 0..25)
            for (j in 0..25)
                if (i != j && s[i] && s[j] && g[i][j]) indegree[j]++
        val q = mutableListOf<Int>()
        for (i in 0..25)
            if (s[i] && indegree[i] == 0) q.add(i)
        val res = StringBuilder()
        while (q.isNotEmpty()) {
            val t = q.removeFirst()
            res.append((t + 'a'.code).toChar())
            for (i in 0..25)
                if (i != t && s[i] && g[t][i])
                    if (--indegree[i] == 0) q.add(i)
        }
        return if (res.length < cnt) "" else res.toString()
    }

}