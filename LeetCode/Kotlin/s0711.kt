import java.util.*

class Solution711 {
    fun numDistinctIslands2(grid: Array<IntArray>): Int {
        val (m, n) = grid.size to grid[0].size
        val s = mutableSetOf<List<List<Int>>>()

        fun normalize(shape: List<Int>): List<List<Int>> {
            val shapes = Array(8) { mutableListOf<IntArray>() }
            for (e in shape) {
                val i = e / n
                val j = e % n
                shapes[0].add(intArrayOf(i, j))
                shapes[1].add(intArrayOf(i, -j))
                shapes[2].add(intArrayOf(-i, j))
                shapes[3].add(intArrayOf(-i, -j))
                shapes[4].add(intArrayOf(j, i))
                shapes[5].add(intArrayOf(j, -i))
                shapes[6].add(intArrayOf(-j, i))
                shapes[7].add(intArrayOf(-j, -i))
            }
            for (e in shapes) {
                e.sortWith { a: IntArray, b: IntArray ->
                    val (i1, j1) = a
                    val (i2, j2) = b
                    if (i1 == i2) j1 - j2 else i1 - i2
                }
                val (a, b) = e[0]
                for (k in e.indices.reversed()) {
                    val (i, j) = e[k]
                    e[k] = intArrayOf(i - a, j - b)
                }
            }
            Arrays.sort(shapes) { a: List<IntArray>, b: List<IntArray> ->
                for (k in a.indices) {
                    val (i1, j1) = a[k]
                    val (i2, j2) = b[k]
                    if (i1 != i2) return@sort i1 - i2
                    if (j1 != j2) return@sort j1 - j2
                }
                0
            }
            return shapes[0].map { it.toList() }
        }

        fun dfs(i: Int, j: Int, shape: MutableList<Int>) {
            shape.add(i * n + j)
            grid[i][j] = 0
            val dirs = intArrayOf(-1, 0, 1, 0, -1)
            for (k in 0..3) {
                val (x, y) = i + dirs[k] to j + dirs[k + 1]
                if (x in 0..<m && y in 0..<n && grid[x][y] == 1) dfs(x, y, shape)
            }
        }

        for (i in 0..<m)
            for (j in 0..<n)
                if (grid[i][j] == 1) {
                    val shape = mutableListOf<Int>()
                    dfs(i, j, shape)
                    s.add(normalize(shape))
                }
        return s.size
    }

}