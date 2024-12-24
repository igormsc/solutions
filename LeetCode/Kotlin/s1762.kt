class Solution1762 {
    fun findBuildings(heights: IntArray): IntArray {
        val res = mutableListOf<Int>()
        var mx = 0
        for (i in heights.indices.reversed())
            if (heights[i] > mx) {
                res.add(i)
                mx = heights[i]
            }
        res.reverse()
        return res.toIntArray()
    }

}