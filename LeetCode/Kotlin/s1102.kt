class Solution1102 {
    fun maximumMinimumPath(grid: Array<IntArray>): Int {
        val (m,n) = grid.size to grid[0].size
        val uf = UnionFind(m * n)
        val q = mutableListOf<IntArray>()
        for (i in 0..<m)
            for (j in 0..<n)
                q.add(intArrayOf(grid[i][j], i, j))

        q.sortWith { a: IntArray, b: IntArray -> b[0] - a[0] }
        val vis = Array(m) { BooleanArray(n) }
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        var res = 0
        var i = 0
        while (uf.find(0) != uf.find(m * n - 1)) {
            val t = q[i]
            vis[t[1]][t[2]] = true
            res = t[0]
            for (k in 0..3) {
                val x = t[1] + dirs[k]
                val y = t[2] + dirs[k + 1]
                if (x in 0..<m && y in 0..<n && vis[x][y])
                    uf.union(x * n + y, t[1] * n + t[2])
            }
            i++
        }
        return res
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n) {it}
        private val size = IntArray(n) {1}

        fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }

        fun union(a: Int, b: Int) {
            val pa = find(a)
            val pb = find(b)
            if (pa != pb) {
                if (size[pa] > size[pb]) {
                    p[pb] = pa
                    size[pa] += size[pb]
                } else {
                    p[pa] = pb
                    size[pb] += size[pa]
                }
            }
        }
    }

}