class Solution79 {
    fun exist(board: Array<CharArray>, word: String): Boolean = board.indices
            .find { i ->
                        lateinit var chk: (p: Pair<Int, Int>, q: Int) -> Boolean
                        chk = fun(p: Pair<Int, Int>, q: Int): Boolean {
                                    val (i, j) = p
                                    if (q == word.length) return true
                                    if (!(i in 0..board.lastIndex && j in 0..board[0].lastIndex) || board[i][j] != word[q]) return false
                                    board[i][j] = '$'
                                    return listOf(i + 1 to j, i - 1 to j, i to j - 1, i to j + 1)
                                                .fold(false) { l, d -> l || chk(d, q + 1) }
                                                .also { board[i][j] = word[q] }
                                }
                        board[i].indices.find { j -> chk(i to j, 0) } != null
            } != null
}