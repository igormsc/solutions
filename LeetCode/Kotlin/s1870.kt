import kotlin.math.ceil

class Solution1870 {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        var (l, r) = 1 to Int.MAX_VALUE/4
        var res = -1
        while (l<=r) {
            val m = (l+r)/2
            val s = dist.dropLast(1).sumOf{ ceil(it.toDouble()/m.toDouble()) } + (dist.last().toDouble()/m.toDouble())
            if (s>hour) l = m+1 else res=m.also{r=m-1}
        }
        return res
    }
}
