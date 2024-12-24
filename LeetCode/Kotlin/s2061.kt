class Solution2061 {
    fun numberOfCleanRooms(room: Array<IntArray>): Int {
        val dirs = intArrayOf(0, 1, 0, -1, 0)
        var (i, j, k) = intArrayOf(0,0,0)
        val (m, n) = room.size to room[0].size
        val vis = Array(m) { Array(n) { BooleanArray(4) } }
        var res = 0
        while (!vis[i][j][k]) {
            vis[i][j][k] = true
            if (room[i][j] == 0) res++
            room[i][j] = -1
            val (x, y) = i + dirs[k] to j + dirs[k + 1]
            if (x in 0..<m && y in 0..<n && room[x][y] != 1) {
                i = x
                j = y
            } else k = (k + 1) % 4
        }
        return res
    }

}