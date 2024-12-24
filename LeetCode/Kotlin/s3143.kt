import java.util.*
import kotlin.math.absoluteValue

class Solution3143 {
    fun maxPointsInsideSquare(points: Array<IntArray>, s: String): Int {
        val m: MutableMap<Int, MutableList<Char>> = TreeMap()
        points.forEachIndexed{ i, p -> m.computeIfAbsent(maxOf(p[0].absoluteValue, p[1].absoluteValue)) { mutableListOf() }.add(s[i]) }
        val sc = mutableSetOf<Char>()
        var cnt = 0
        for ((_, v) in m) {
            for (u in v) {
                if (sc.contains(u)) return cnt
                sc.add(u)
            }
            cnt += v.size
        }
        return cnt
    }

}

fun main() {

    val points = "[[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]]"
        .trim('[', ']').split("],[")
        .map{ s -> s.split(",").map { v -> v.toInt() }.toIntArray() }.toTypedArray()


    val s = "abdca"

    val sl = Solution3143()
    println(sl.maxPointsInsideSquare(points, s))
    println("Output: 2")

}