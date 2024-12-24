class Solution840 {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        if (grid.size < 3 || grid[0].size < 3) return 0

        fun isValid(x: Int, y: Int): Boolean {
            val d = listOf(-1,0,1)
            val cnt = IntArray(16)
            d.indices.forEach { i ->
                d.indices.forEach { j -> cnt[grid[x+d[i]][y+d[j]]]++}
            }
            return cnt.slice(1..9).all{ it == 1 }
        }

        return (1..<grid.lastIndex).sumOf { i ->
                    (1..<grid[0].lastIndex).count{ j ->
                        grid[i][j] == 5 && grid[i][j-1]+grid[i][j+1] == 10 &&
                        grid[i-1][j]+grid[i+1][j] == 10 && grid[i-1][j-1]+grid[i+1][j+1] == 10 &&
                        grid[i+1][j-1]+grid[i-1][j+1] == 10 && grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1] == 15 &&
                        grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1] == 15 && grid[i-1][j-1]+grid[i][j-1]+grid[i+1][j-1] == 15 &&
                        grid[i-1][j+1]+grid[i][j+1]+grid[i+1][j+1] == 15 && isValid (i,j)
                    }
                }
    }

}
