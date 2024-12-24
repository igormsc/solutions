import kotlin.math.pow
import kotlin.math.sqrt

class Solution3200 {
    fun maxHeightOfTriangle(red: Int, blue: Int): Int {
        val (red, blue) = if (red<blue) blue to red else red to blue

        val (h1, h2) = sqrt(blue.toDouble() * 4 + 1).toInt() to sqrt(blue.toDouble()).toInt() * 2
        return when {
            (h1 + 1).toDouble().pow(2).toInt() / 4 <= red -> h1
            ((h2 + 1).toDouble().pow(2) - 1).toInt() / 4 <= red -> h2
            (h1 - 1).toDouble().pow(2).toInt() / 4 <= red -> h1 - 1
            else -> h2 - 1
        }
    }

}
