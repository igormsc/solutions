class Solution2290 {
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val dirs = arrayOf(intArrayOf(0,1), intArrayOf(0,-1), intArrayOf(1,0), intArrayOf(-1,0))
        val (m,n) = grid.size to grid[0].size
        var res = 0
        var emp = mutableListOf(intArrayOf(0,0))
        var obs = mutableListOf<IntArray>()
        while (emp.isNotEmpty() || obs.isNotEmpty()) {
            if (emp.isEmpty()) {
                res++
                emp = obs .also{ obs = emp}
            }
            val (i,j)= emp.removeFirst()
            if (i == m-1 && j == n-1) break
            dirs.forEach { (dx,dy) ->
                val (x,y) = i+dx to j+dy
                if (x in 0..<m && y in 0..<n && grid[x][y] >=0) {
                    if (grid[x][y] !=0 ) obs.add(intArrayOf(x,y)) else emp.add(intArrayOf(x,y))
                    grid[x][y] = -1
                }
            }
        }
        return res
    }
}
