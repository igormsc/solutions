class Solution1971 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val ds = IntArray(n) {-1}

        fun find(i: Int): Int = if (ds[i] < 0) i else find(ds[i]).also { ds[i] = it }

        edges.forEach { e ->
            val p = find(e[0]) to find(e[1])
            if (p.first != p.second) ds[p.second] = p.first
        }

        return find(source) == find(destination)
    }

}
