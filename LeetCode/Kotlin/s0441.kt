import kotlin.math.sqrt

class Solution441 {
    fun arrangeCoins(n: Int): Int = ((sqrt(8.0*n.toDouble()+1.0)-1.0)/2.0).toInt()
}
