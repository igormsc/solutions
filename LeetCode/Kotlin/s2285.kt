class Solution2285 {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long =
        roads
            .fold(IntArray(n)) { c, r -> c[r[0]]++; c[r[1]]++; c }
            .sorted()
            .withIndex()
            .sumOf { it.value.toLong() * (it.index + 1).toLong() }

}
