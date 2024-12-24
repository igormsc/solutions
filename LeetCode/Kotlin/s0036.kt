class Solution036 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val (rows, cols) = Array(9) { IntArray(9) } to Array(9) { IntArray(9) }
        val blocks = Array(3) { Array(3) { IntArray(9) } }
        (0..8).forEach { r ->
            (0..8).forEach{ c ->
                if (board[r][c] != '.') {
                    val n = board[r][c].code - '1'.code
                    if (rows[r][n] > 0) return false else rows[r][n]++
                    if (cols[c][n] > 0) return false else cols[c][n]++
                    if (blocks[r/3][c/3][n] > 0) return false else blocks[r/3][c/3][n]++
                }
            }
        }
        return true
    }
}