class Solution773 {
    fun slidingPuzzle(board: Array<IntArray>): Int {
        var curr = StringBuilder()
        var tar = "123450"
        (0..1).forEach { i ->
            (0..2).forEach { j -> curr.append((board[i][j] + '0'.code).toChar())} }
        val nei = mutableMapOf( 0 to mutableListOf(1,3), 1 to mutableListOf(0,2,4), 2 to mutableListOf(1,5),
            3 to mutableListOf(0,4), 4 to mutableListOf(1,3,5), 5 to mutableListOf(2,4))

        val q = mutableListOf(curr.toString() to 0)
        val vis = mutableSetOf(curr.toString())
        var res = -1
        while (q.isNotEmpty()) {
            val (str, dis) = q.removeFirst()
            if (str == tar) {
                res = dis
                break
            }
            val id0 = str.indexOf('0')
            nei[id0]!!.forEach { ne ->
                val swp = swap(str, ne, id0)
                if (!vis.contains(swp)) {
                    vis.add(swp)
                    q.add(swp to dis+1)
                }
            }
        }
        return res
    }

    private fun swap(str: String, i: Int, j: Int): String {
        val sw = str.toCharArray()
        sw[i] = sw[j].also{ sw[j] = sw[i] }
        return sw.joinToString("")
    }

}
