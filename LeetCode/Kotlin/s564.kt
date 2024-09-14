import kotlin.math.absoluteValue
import kotlin.math.pow

class Solution564 {
    fun nearestPalindromic(n: String): String {
        val ln = n.length
        val left = n.substring(0..<ln / 2 + ln % 2).toLong()
        val nInt = n.toLong()

        fun gen(left: Long, even: Boolean): Long {
            var p = left
            var l = if (!even) left / 10 else left
            while (l > 0) {
                p = p * 10 + l % 10
                l /= 10
            }
            return p
        }

       return listOf(gen(left, ln % 2 == 0), gen(left + 1, ln % 2 == 0), gen(left - 1, ln % 2 == 0),
                        10.0.pow(ln - 1).toLong() - 1, 10.0.pow(ln).toLong() + 1)
                    .filter { it != nInt }.minWith(compareBy<Long> { (nInt - it).absoluteValue }.thenBy { it }).toString()
    }
}
