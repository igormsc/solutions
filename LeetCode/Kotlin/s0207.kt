class Solution207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val g = Array(numCourses) {mutableSetOf<Int>()}
        val idg = IntArray(numCourses)
        prerequisites.forEach { (u,v) ->
            g[v].add(u)
            idg[u]++
        }
        val q = idg.indices.fold(mutableListOf<Int>()){ r, i -> if (idg[i]==0) r.add(i); r}
        var cnt = 0
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            cnt++
            g[u].forEach { v -> if (--idg[v] == 0) q.add(v) }
        }
        return cnt == numCourses
    }
}
