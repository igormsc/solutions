import kotlin.math.absoluteValue

class Solution1544 {
    fun makeGood(s: String): String = s.toCharArray().let { b ->
            b.fold(0) { p, c -> p + if (p > 0 && (c - b[p - 1]).absoluteValue == 32) -1 else 1.also{ b[p] = c }
            }.let { j -> b.slice(0..<j).joinToString("") } }

}
