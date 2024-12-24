class Solution1926 {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val dirs = intArrayOf(0,-1,0,1,0)
        val q = mutableListOf(intArrayOf(entrance[0], entrance[1], 0))
        while (q.isNotEmpty()) {
            val (i, j, steps) = q.removeFirst()
            if ((i!=entrance[0] || j != entrance[1]) && (i == 0 || i == maze.lastIndex || j == 0 || j == maze[i].lastIndex )) return steps
            (0..3).forEach { d ->
                val (x, y) = i + dirs[d] to j + dirs[d + 1]
                if (x in maze.indices && y in maze[0].indices && maze[x][y] == '.') {
                    maze[x][y] = '+'
                    q.add(intArrayOf(x, y, steps+1))
                }
            }
        }
        return -1
    }
}
