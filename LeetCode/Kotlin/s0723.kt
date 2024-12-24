import kotlin.math.absoluteValue

class Solution723 {
    fun candyCrush(board: Array<IntArray>): Array<IntArray> {
        val (m, n) = board.size to board[0].size
        var flg = true

        while (flg) {
            flg = false
            for (i in 0..<m)
                for (j in 2..<n)
                    if (board[i][j] != 0 && board[i][j].absoluteValue == board[i][j - 1].absoluteValue && board[i][j].absoluteValue == board[i][j - 2].absoluteValue) {
                        flg = true
                        val v = board[i][j].absoluteValue
                        board[i][j - 2] = -v
                        board[i][j - 1] = board[i][j - 2]
                        board[i][j] = board[i][j - 1]
                    }
            for (j in 0..<n)
                for (i in 2..<m)
                    if (board[i][j] != 0 && board[i][j].absoluteValue == board[i - 1][j].absoluteValue && board[i][j].absoluteValue == board[i - 2][j].absoluteValue) {
                        flg = true
                        val v = board[i][j].absoluteValue
                        board[i - 2][j] = -v
                        board[i - 1][j] = board[i - 2][j]
                        board[i][j] = board[i - 1][j]
                    }
            if (flg)
                for (j in 0..<n) {
                    var k = m - 1
                    for (i in m - 1 downTo 0)
                        if (board[i][j] > 0) board[k--][j] = board[i][j]
                    while (k >= 0) board[k--][j] = 0
                }
        }
        return board
    }

}
