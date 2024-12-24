class Solution1229 {
    fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
        slots1.sortBy { it[0] }
        slots2.sortBy { it[0] }
        val (m, n) = slots1.size to slots2.size
        var (i, j) = 0 to 0
        while (i < m && j < n) {
            val start = maxOf(slots1[i][0], slots2[j][0])
            val end = minOf(slots1[i][1], slots2[j][1])
            if (end - start >= duration) return listOf(start, start + duration)
            if (slots1[i][1] < slots2[j][1]) i++
            else j++
        }
        return listOf()
    }
}