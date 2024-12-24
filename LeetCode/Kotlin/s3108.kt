class Solution3108 {
    fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val (ds, cost) = IntArray(n) { -1 } to IntArray(n) { -1 };
        fun find(i: Int): Int = if (ds[i] < 0) i else find(ds[i]).also { ds[i] = it }
        edges.forEach { e ->
            val p = find(e[0]) to find(e[1])
            if (p.first != p.second) cost[p.first] = cost[p.first].and(cost[p.second]).also { ds[p.second] = p.first }
            cost[p.first] = cost[p.first].and(e[2])
        }
        return query.fold(mutableListOf<Int>()) { r, q ->
            if (q[0] == q[1]) r.add(0) else (Pair(find(q[0]), find(q[1])).also { if (it.first != it.second) r.add(-1) else r.add(cost[it.first]) })
            r
        }.toIntArray()
    }
}
