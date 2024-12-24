class Solution305 {
    fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int> {
        val grid = Array(m) { IntArray(n) }
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        val res = mutableListOf<Int>()
        val uf = UnionFind(m * n)
        var cnt = 0
        positions.forEach { p ->
            val (i, j) = p
            if (grid[i][j] == 1) res.add(cnt)
            else {
                grid[i][j] = 1
                cnt++
                (0..3).forEach { k ->
                    val (x, y) = i + dirs[k] to j + dirs[k + 1]
                    if (x in 0..<m && y >= 0 && y < n && grid[x][y] == 1 && uf.union(i * n + j, x * n + y)) cnt--
                }
                res.add(cnt)
            }
        }
        return res
    }

    internal class UnionFind(n: Int) {
        private val p = IntArray(n) { it }
        private val size = IntArray(n) {1}

        fun find(x: Int): Int {
            if (p[x] != x) p[x] = find(p[x])
            return p[x]
        }

        fun union(a: Int, b: Int): Boolean {
            val (pa, pb) = find(a) to find(b)
            if (pa == pb) return false
            if (size[pa] > size[pb]) {
                p[pb] = pa
                size[pa] += size[pb]
            } else {
                p[pa] = pb
                size[pb] += size[pa]
            }
            return true
        }
    }

}