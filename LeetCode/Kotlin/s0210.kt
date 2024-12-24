class Solution210 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val g = Array(numCourses) { mutableListOf<Int>() }
        val nodes = mutableListOf<Int>()
        val idg = IntArray(numCourses)
        val res = mutableListOf<Int>()
        var cnt = 0
        prerequisites.forEach{(u,v) ->
            g[v].add(u)
            idg[u]++
        }
        idg.indices.forEach { if (idg[it] == 0) nodes.add(it) }
        while (nodes.isNotEmpty()) {
            cnt++
            val u = nodes.removeFirst()
            res.add(u)
            g[u].forEach{if (--idg[it] == 0) nodes.add(it)}
        }
        return if (cnt==numCourses) res.toIntArray() else intArrayOf()
    }
}
