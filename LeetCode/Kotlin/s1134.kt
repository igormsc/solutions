import kotlin.math.pow

class Solution1134 {
    fun isArmstrong(n: Int): Boolean {
        val k = (n.toString() + "").length
        var (s, x) = 0 to n
        while (x > 0) {
            s += (x % 10).toDouble().pow(k).toInt()
            x /= 10
        }
        return s == n
    }
}