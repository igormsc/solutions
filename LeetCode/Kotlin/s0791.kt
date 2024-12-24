class Solution791 {
    fun customSortString(order: String, s: String): String {
        val frq = s.fold(IntArray(255)) { r, c -> r[c.code]++; r}
        val sb = order.fold(StringBuilder()) { sb, o -> repeat(frq[o.code]) {sb.append(o)}; frq[o.code] = 0; sb  }
        return frq.withIndex().filter { it.value > 0 }.fold(sb) { sb, v -> repeat(v.value) { sb.append(v.index.toChar())}; sb }.toString()
    }
}
