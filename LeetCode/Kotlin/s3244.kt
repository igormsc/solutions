class Solution3244 {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val m = mutableMapOf<Int,Int>()
        (0..<n-1).forEach { m[it] = it + 1 }
        return queries.foldIndexed(IntArray(queries.size)) { z, r, q ->
                    val (i, j) = q
                    if (m.containsKey(i) && m[i]!!<j) {
                    var x = i
                    while (x<j && m.containsKey(x)) x = m.remove(x)!!
                    m[i] = j
            }
           r[z] = m.size
           r }
    }
}
