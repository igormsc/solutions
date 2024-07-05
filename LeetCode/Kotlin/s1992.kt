class Solution1992 {
    fun findFarmland(land: Array<IntArray>): Array<IntArray> =
        land.indices.fold(mutableListOf<IntArray>()) { r, i ->
            var j = 0
            while (j < land[0].size) {
                if (land[i][j] == 1) {
                    var (x, y) = i to j
                    while (y < land[0].size && land[i][y] != 0) y++
                    while (x < land.size && land[x][j] != 0) land[x++][j] = y-j+1
                    r.add(intArrayOf(i, j, x - 1, y - 1))
                }
                j += if (land[i][j] > 1) land[i][j] else 1
            }
        r }.toTypedArray()

}
