import kotlin.math.sqrt

class Solution2485 {
    fun pivotInteger(n: Int): Int =
        sqrt ((n*(n+1)/2).toDouble()).let{ if (it.rem(1) == 0.0) it.toInt() else -1 }

}
