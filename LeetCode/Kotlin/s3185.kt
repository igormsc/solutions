class Solution3185 {
    fun countCompleteDayPairs(hours: IntArray): Long {
        val m = mutableMapOf<Int,Int>()
        var r = 0L
        hours.forEach { h ->
            r += (m[(24-h%24)%24]?:0).toLong()
            m[h%24] = (m[h%24]?:0) + 1
        }
        return r
    }
}