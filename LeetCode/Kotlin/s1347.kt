import kotlin.math.absoluteValue

class Solution1347 {
    fun minSteps(s: String, t: String): Int =
        s.foldIndexed(IntArray(256)) { i, a, c -> a[c.code]++; a[t[i].code]--; a}
         .sumOf { if (it<0) it else 0 }.absoluteValue
}