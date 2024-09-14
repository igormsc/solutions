class Solution2326 {
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        var (i,j,d) = intArrayOf(0,0,0)
        val dirs = intArrayOf(0, 1, 0, -1, 0)
        val res = Array(m) { IntArray(n) { -1 } }

        var node = head
        while (node != null) {
            res[i][j] = node.`val`
            val (x, y) = i+dirs[d] to j+dirs[d+1]
            if (minOf(x,y)<0 || x >=m || y >=n || res[x][y] != -1) d = (d+1)%4
            i += dirs[d]
            j += dirs[d+1]
            node = node.next
        }
        return res
    }
}
