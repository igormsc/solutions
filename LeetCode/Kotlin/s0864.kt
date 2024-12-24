class Solution864 {
    fun shortestPathAllKeys(grid: Array<String>): Int {
        val (m, n) = grid.size to grid[0].length
        if (m == 0 || n == 0) return 0
        var path = 0
        var k = 0
        val dirs = intArrayOf(0, -1, 0, 1, 0)
        val vis = Array(m) {Array(n) { BooleanArray(64) } }
        val q = mutableListOf<Pair<Int,Int>>()
        (0..<m).forEach { i ->
            (0..<n).forEach { j ->
                if (grid[i][j] == '@') q.add(i*n+j to 0).also{vis[i][j][0] = true}
                if (grid[i][j] in 'A'..'F') k++
            }
        }
        while (q.isNotEmpty()) {
            val sz = q.size
            for (i in 0..sz) {
                val (a, b) = q.first().first / n to q.first().first % n
                val car = q.removeFirst().second
                if (car == 1.shl(k) - 1) return path
                for (j in 0..3) {
                    val (x, y) = a + dirs[j] to b + dirs[j + 1]
                    var u = car
                    if (x in 0..<m && y in 0..<n && grid[x][y] != '#') {
                        if (grid[x][y] in 'a'..'f') u = car.or(1.shl(grid[x][y].code - 'a'.code))
                        else if (grid[x][y] in 'A'..'F' &&  car.and(1.shl(grid[x][y].code - 'A'.code)) == 0) continue
                        if (!vis[x][y][u]) q.add(x*n + y to u).also{vis[x][y][u] = true}
                    }
                }
            }
            path++
        }
        return -1
    }
}
