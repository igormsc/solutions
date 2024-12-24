class TicTacToe(n: Int) {
    private var cnt = Array(6 * n) { IntArray(3) }
    private val n = n

    fun move(row: Int, col: Int, player: Int): Int {
        for (x in intArrayOf(row, n + col, 2 * n + row + col, 5 * n + row - col)) if (++cnt[x][player] == n) return player
        return 0
    }
}