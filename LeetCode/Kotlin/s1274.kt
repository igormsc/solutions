class Solution1274 {
    fun countShips(sea: Sea, topRight: IntArray, bottomLeft: IntArray): Int {
        val (x1, y1) = bottomLeft
        val (x2,y2) = topRight
        if (x1 > x2 || y1 > y2) return 0
        if (!sea.hasShips(topRight, bottomLeft)) return 0
        if (x1 == x2 && y1 == y2) return 1
        val (midx, midy) = (x1 + x2)/2 to (y1 + y2)/2
        val a = countShips(sea, topRight, intArrayOf(midx + 1, midy + 1))
        val b = countShips(sea, intArrayOf(midx, y2), intArrayOf(x1, midy + 1))
        val c = countShips(sea, intArrayOf(midx, midy), bottomLeft)
        val d = countShips(sea, intArrayOf(x2, midy), intArrayOf(midx + 1, y1))
        return a + b + c + d
    }
}

abstract class Sea {
    abstract fun hasShips(topRight: IntArray, bottomLeft: IntArray): Boolean
}
