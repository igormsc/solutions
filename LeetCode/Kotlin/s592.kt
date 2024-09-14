import kotlin.math.absoluteValue

class Solution592 {
    fun fractionAddition(expression: String): String {
        fun gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b, a%b)
        var (n,d,p) = intArrayOf(0,1,0)
        val s = if (expression[0] != '-') mutableListOf('+') else mutableListOf()
        s.addAll(expression.toList())
        while (p<s.size) {
            var p1 = p+1
            while (s[p1] != '/') p1++
            var p2 = p1+1
            while (p2<s.size && s[p2] != '+' && s[p2] != '-') p2++
            val nn = s.slice(p+1..<p1).joinToString("").toInt()
            val dd = s.slice(p1+1..<p2).joinToString("").toInt()
            val gc = gcd(nn, dd)
            val sng = if (s[p] == '-') -1 else 1
            n = n*dd/gc + sng*nn*d/gc
            d *= dd/gc
            p = p2
        }
        val gc = gcd(n.absoluteValue, d)
        return "%d/%d".format(n/gc, d/gc)
    }
}