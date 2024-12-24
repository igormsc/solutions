class Solution1061 {
    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        val uf = IntArray(26) {it}
        fun find(x: Int): Int = if (uf[x] != x) find(uf[x]).also{uf[x]=it} else uf[x]
        s1.indices.forEach { i ->
            val (a, b) = find(s1[i].code - 'a'.code) to find(s2[i].code - 'a'.code)
            if (a<b) uf[b] = a else uf[a] = b}
        return buildString { baseStr.forEach { c -> append(('a'.code + find(c.code-'a'.code)).toChar()) } }
    }
}
