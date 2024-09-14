class Solution3257 {
    fun maximumValueSum(board: Array<IntArray>): Long {
        val b = Array(board.size) { IntArray(board[0].size) }.also {it[0] = board[0].copyOf()}
        for (i in 1..board.lastIndex)
            for (j in board[0].indices)
                b[i][j] = maxOf(b[i-1][j], b[i][j])
        val bd = Array(board.size) { IntArray(board[0].size) }.also {it[it.lastIndex] = board.last().copyOf()}
        for (i in board.lastIndex-1 downTo 0)
            for (j in board[0].indices)
                bd[i][j] = maxOf(bd[i+1][j], board[i][j])
        var res = Long.MIN_VALUE
        for (i in 1..<board.lastIndex) {
            val mx = arrayOf(max3(b[i - 1]), max3(board[i]), max3(bd[i+1]))
            for (tc in mx[0])
                for (cc in mx[1])
                    for (bc in mx[2])
                        if (tc[1] != cc[1] && tc[1] != bc[1] && cc[1] != bc[1])
                            res = maxOf(res, tc[0].toLong() + cc[0] + bc[0])
        }
        return res
    }

    private fun max3(r: IntArray): Array<IntArray> {
        val res = r.withIndex().map{ intArrayOf(it.value, it.index) }
        res.sortedByDescending { it[0] }
        return res.take(11).toTypedArray()
    }
}