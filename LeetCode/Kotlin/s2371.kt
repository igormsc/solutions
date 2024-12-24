class Solution2371 {
    fun minScore(grid: Array<IntArray>): Array<IntArray> {
        val (m,n) = grid.size to grid[0].size
        val nums = mutableListOf<IntArray>()
        for (i in 0..<m)
            for (j in 0..<n)
                nums.add(intArrayOf(grid[i][j], i, j))
        nums.sortBy { it[0] }

        val rowMax = IntArray(m)
        val colMax = IntArray(n)
        val res = Array(m) { IntArray(n) }
        for (num in nums) {
            val (_, i, j) = num
            res[i][j] = maxOf(rowMax[i], colMax[j]) + 1
            rowMax[i] = res[i][j]
            colMax[j] = res[i][j]
        }
        return res
    }

}
