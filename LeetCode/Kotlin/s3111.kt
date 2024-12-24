import java.util.*

class Solution3111 {
    fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
        points.sortBy { it[0] }
        return points.fold(0 to -1) { (r, l), p -> if (p[0] > l) r + 1 to p[0] + w else r to l }.first
    }
}
