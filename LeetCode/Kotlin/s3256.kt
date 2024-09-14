class Solution3256 {
    fun maximumValueSum(board: Array<IntArray>): Long {
        val b = board.indices.fold(mutableListOf<IntArray>()) { r, i ->
                    val s = board[0].indices.fold(mutableListOf<IntArray>()) { x, j -> x.add(intArrayOf(board[i][j], i, j)); x}
                    s.sortByDescending { it[0] }
                    (0..minOf(board[0].size,2)).forEach{ r.add(s[it]) }
                    r}
        var res = Long.MIN_VALUE
        for (i in b.indices)
            for (j in i+1..b.lastIndex)
                for (k in j+1..b.lastIndex)
                    if(b[i][1] != b[j][1] && b[j][1] != b[k][1] && b[i][1]!=b[k][1] && b[i][2] != b[j][2] && b[i][2]!=b[k][2] && b[j][2] != b[k][2])
                        res = maxOf(res, b[i][0].toLong() + b[j][0] + b[k][0])
        return res
    }
}