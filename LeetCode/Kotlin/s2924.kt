class Solution2924 {
    fun findChampion(n: Int, edges: Array<IntArray>): Int {
        val lost = edges.fold(BooleanArray(n)) { r, e -> r[e[1]] = true; r }
        val j = lost.indices.find { !lost[it] } ?: lost.size
        return if (lost.count { !it } == 1) j else -1
    }

}
