class Solution3078 {
    fun findPattern(board: Array<IntArray>, pattern: Array<String>): IntArray {
        val (m, n) = board.size to board[0].size
        val (r, c) = pattern.size to pattern[0].length

        fun chk(i: Int, j: Int): Boolean {
            val (d1, d2) = IntArray(26) {-1} to IntArray(10) {-1}
            for (a in pattern.indices) {
                for (b in 0..pattern[0].lastIndex) {
                    val (x, y) = i + a to j + b
                    if (Character.isDigit(pattern[a][b])) {
                        val v = pattern[a][b].code - '0'.code
                        if (v != board[x][y]) return false
                    } else {
                        val v = pattern[a][b].code - 'a'.code
                        if (d1[v] != -1 && d1[v] != board[x][y]) return false
                        if (d2[board[x][y]] != -1 && d2[board[x][y]] != v) return false
                        d1[v] = board[x][y]
                        d2[board[x][y]] = v
                    }
                }
            }
            return true
        }

        for (i in 0..<m - r + 1)
            for (j in 0..<n - c + 1)
                if (chk(i, j)) return intArrayOf(i, j)
        return intArrayOf(-1, -1)
    }

}