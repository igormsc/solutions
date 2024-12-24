class Solution261 {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        var n = n
        val p = IntArray(n) { it }

        fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }

        for (e in edges) {
            val (pa, pb) = find(e[0]) to find(e[1])
            if (pa == pb) return false
            p[pa] = pb
            n--
        }
        return n == 1
    }

}