class Solution356 {
    fun isReflected(points: Array<IntArray>): Boolean {
        var (minX, maxX) = Int.MAX_VALUE/2 to Int.MIN_VALUE/2
        val set = mutableSetOf<Pair<Int,Int>>()
        for ((x,y) in points) {
            minX = minOf(minX, x)
            maxX = maxOf(maxX, x)
            set.add(x to y)
        }
        val s = minX + maxX
        for ((x,y) in points)
            if (!set.contains(s - x to y))  return false
        return true
    }

}