class Solution452 {
    fun findMinArrowShots(points: Array<IntArray>): Int = if (points.size <= 1) points.size else
        points.also { it.sortBy { it[1] } }.drop(1).fold(points[0][1] to 1) { (p, a), c ->  if (c[0] > p) c[1] to a + 1 else p to a }.second

}
