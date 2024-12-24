import kotlin.math.pow

class Solution2417 {
    fun closestFair(n: Int): Int {
        var a = 0
        var b = 0
        var k = 0
        var t = n
        while (t > 0) {
            if ((t % 10) % 2 == 1) a++
            else b++
            t /= 10
            k++
        }
        if (k % 2 == 1) {
            val x = 10.0.pow(k).toInt()
            var y = 0
            for (i in 0..<(k shr 1)) y = y * 10 + 1
            return x + y
        }
        if (a == b) return n
        return closestFair(n + 1)
    }

}