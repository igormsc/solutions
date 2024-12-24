import kotlin.math.absoluteValue

class Solution2582 {
    fun passThePillow(n: Int, time: Int): Int = n - (n-1-time%(n*2-2)).absoluteValue
}
