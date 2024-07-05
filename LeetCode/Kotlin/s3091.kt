import kotlin.math.sqrt

class Solution3091 {
    fun minOperations(k: Int): Int = sqrt(k.toDouble()).toInt().let { it + (k-1)/it - 1 }
}
