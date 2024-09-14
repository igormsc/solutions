
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.absoluteValue

class Solution3235 {
    fun canReachCorner(X: Int, Y: Int, circles: Array<IntArray>): Boolean {
        val n = circles.size
        val als: Array<ArrayList<Int>> = Array(n) {ArrayList()}
        for (i in 0..<n)
            for (j in i + 1..<n) {
                var a = (circles[i][0] - circles[j][0]).absoluteValue.toLong()
                var b = (circles[i][1] - circles[j][1]).absoluteValue.toLong()
                var d = (circles[i][2] + circles[j][2]).toLong()
                if (a * a + b * b <= d * d) {
                    a = (circles[j][1] - circles[i][1]).toLong()
                    b = (circles[i][0] - circles[j][0]).toLong()
                    d = circles[j][0].toLong()
                    d *= circles[i][1].toLong()
                    var d2 = circles[i][0].toLong()
                    d2 *= circles[j][1].toLong()
                    d -= d2
                    if ((a == 0L && ((b < 0 && -d >= b * Y) || (b > 0 && -d <= b * Y))) || (b == 0L && ((a < 0 && -d >= a * X) || (a > 0 && -d <= a * X))) || (a != 0L && b > 0 && b * Y >= -d - a * X) || (a != 0L && b < 0 && b * Y <= -d - a * X) || (b != 0L && a > 0 && a * X >= -d - b * Y) || (b != 0L && a < 0 && a * X <= -d - b * Y)) {
                        als[i].add(j)
                        als[j].add(i)
                    }
                }
            }

        val seen = BooleanArray(n)
        for (i in 0..<n) if (!seen[i] && check(circles[i], 1, 0, X) && dfs(als, i, circles, seen, 0, 0, Y)) return false

        Arrays.fill(seen, false)
        for (i in 0..<n) if (!seen[i] && check(circles[i], 1, 0, X) && dfs(als, i, circles, seen, 1, Y, X)) return false

        Arrays.fill(seen, false)
        for (i in 0..<n) if (!seen[i] && check(circles[i], 0, X, Y) && dfs(als, i, circles, seen, 1, Y, X)) return false

        Arrays.fill(seen, false)
        for (i in 0..<n) if (!seen[i] && check(circles[i], 0, 0, Y) && dfs(als, i, circles, seen, 0, X, Y)) return false

        return true
    }

    private fun dfs(als: Array<ArrayList<Int>>, i: Int, ccs: Array<IntArray>, seen: BooleanArray, f: Int, v: Int, v2: Int): Boolean {
        seen[i] = true
        if (check(ccs[i], f, v, v2)) return true
        for (j in als[i]) if (!seen[j] && dfs(als, j, ccs, seen, f, v, v2)) return true
        return false
    }

    private fun check(cc: IntArray, f: Int, v: Int, v2: Int): Boolean =
        if (f == 0) (v - cc[0]).absoluteValue <= cc[2] && cc[1] <= v2 || canReach(cc, v, v2)
        else (v - cc[1]).absoluteValue <= cc[2] && cc[0] <= v2 || canReach(cc, v2, v)

    private fun canReach(cc: IntArray, x: Int, y: Int): Boolean {
        val d = (cc[0] - x).absoluteValue.toLong()
        val d2 = (cc[1] - y).absoluteValue.toLong()
        val d3 = cc[2].toLong()
        return d * d + d2 * d2 <= d3 * d3
    }

}