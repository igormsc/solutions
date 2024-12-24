import java.util.PriorityQueue

class Solution2577 {
    fun minimumTime(grid: Array<IntArray>): Int {
        val pq = PriorityQueue { o1:IntArray, o2:IntArray ->
            when {
                o1[0] == o2[0] && o1[1] == o2[1] -> o2[2] - o1[2]
                o1[0] == o2[0] -> o2[1] - o1[1]
                else -> o2[0] - o1[0]
            }
        }
        val dirs = intArrayOf(0,1,0,-1,0)
        val (m,n) = grid.size to grid[0].size
        if (minOf(grid[0][1],grid[1][0]) > 1) return -1
        val vis = Array(m) { IntArray(n) {Int.MAX_VALUE} }
        pq.add(intArrayOf(0,0,0))
        while (pq.isNotEmpty()) {
            val (neg, i, j) = pq.poll()
            if (i==m-1 && j==n-1) break
            (0..3).forEach { d ->
                val (x,y) = i + dirs[d] to j + dirs[d+1]
                if (x in 0..<m && y in 0..<n) {
                    var sec = 1 - neg
                    if (sec < grid[x][y]) sec = grid[x][y] + (grid[x][y]-sec)%2
                    if (sec<vis[x][y]) {
                        vis[x][y] = sec
                        pq.add(intArrayOf(-sec, x, y))
                    }
                }

            }
        }
        return vis.last().last()
    }
}
