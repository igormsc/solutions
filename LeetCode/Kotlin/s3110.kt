import kotlin.math.absoluteValue

class Solution3110 {
    fun scoreOfString(s: String): Int = s.windowed(2,1).sumOf { (it.first().code - it.last().code).absoluteValue }
}