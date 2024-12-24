import kotlin.math.absoluteValue

class Solution3146 {
    fun findPermutationDifference(s: String, t: String): Int {
        val p = t.withIndex().fold(IntArray(128)) { r, v -> r[v.value.code] = v.index; r }
        return s.indices.sumOf { (it - (p[s[it].code])).absoluteValue }
    }
}