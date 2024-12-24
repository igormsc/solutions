class Solution539 {
    fun findMinDifference(timePoints: List<String>): Int {
        val m = timePoints.fold(mutableListOf<Int>()) { r, p ->
                    r.add(p.substring(0..1).toInt()*60 + p.substring(3..4).toInt())
                    r }
        m.sort()
        var res = 24*60
        m.add(m.first()+res)
        (1..m.lastIndex).forEach { i -> res = minOf(m[i]-m[i-1], res)}
        return res
    }
}