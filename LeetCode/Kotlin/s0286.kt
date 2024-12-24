class Solution286 {

    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val (m, n) = rooms.size to rooms[0].size
        val q = mutableListOf<IntArray>()
        for (i in rooms.indices)
            for (j in rooms[0].indices)
                if (rooms[i][j] == 0) q.add(intArrayOf(i, j))
        var d = 0
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        while (q.isNotEmpty()) {
            d++
            for (i in q.size downTo 1) {
                val p = q.removeFirst()
                for (j in 0..3) {
                    val (x, y) = p[0] + dirs[j] to p[1] + dirs[j + 1]
                    if (x in 0..<m && (y in 0..<n) && rooms[x][y] == Int.MAX_VALUE) {
                        rooms[x][y] = d
                        q.add(intArrayOf(x, y))
                    }
                }
            }
        }
    }

}