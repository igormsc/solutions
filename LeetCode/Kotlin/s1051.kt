class Solution1051 {
    fun heightChecker(heights: IntArray): Int {
        val s = heights.sorted()
        return heights.indices.count { heights[it] != s[it] }
    }
}
