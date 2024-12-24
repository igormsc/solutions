class Solution3127 {
    fun canMakeSquare(grid: Array<CharArray>): Boolean {
        fun change(x: Int, y: Int): Boolean = charArrayOf(grid[x][y], grid[x][y + 1], grid[x + 1][y], grid[x + 1][y + 1])
            .fold(0 to 0) { (b,w), c -> if (c=='B') b+1 to w else b to w+1 }.let { it.first>=3 || it.second >= 3 }
        return arrayOf(0 to 0, 0 to 1, 1 to 0, 1 to 1).fold(false) { r, (x,y) -> r || change(x,y) }
    }

}
