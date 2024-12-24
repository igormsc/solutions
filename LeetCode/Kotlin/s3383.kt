class Solution3383 {
    fun minRunesToAdd(n: Int, crystals: IntArray, flowFrom: IntArray, flowTo: IntArray): Int {
        val (fCon, bCon) = Array(n) { mutableListOf<Int>() } to Array(n) { mutableListOf<Int>() }
        val mark = BooleanArray(n)
        val all = mutableListOf<Int>()
        flowFrom.indices.forEach { i ->
            fCon[flowFrom[i]].add(flowTo[i])
            bCon[flowTo[i]].add(flowFrom[i])
        }

        fun dfsM(i: Int) {
            if (mark[i]) return
            mark[i] = true
            fCon[i].forEach { dfsM(it) }
            all.add(i)
        }
        mark.indices.forEach { dfsM(it) }

        val id = IntArray(n) { -1 }
        fun dfs(i: Int, j: Int) {
            if (id[i] >= 0) return
            id[i] = j
            bCon[i].forEach { dfs(it, j) }
        }

        var x = 0
        (n - 1 downTo 0).forEach { if (id[all[it]] < 0) dfs(all[it], x++) }
        val (to, ok) = BooleanArray(x) to BooleanArray(x)
        flowFrom.indices.forEach { if (id[flowFrom[it]] != id[flowTo[it]]) to[id[flowTo[it]]] = true }
        crystals.forEach { ok[id[it]] = true }
        return (0..<x).count{ !to[it] && !ok[it] }
    }
}
