class Solution3096 {
    fun minimumLevels(possible: IntArray): Int {
        possible.map { if (it != 0) 1 else -1 }.foldIndexed(0) { i, r, n -> possible[i] = r + n; r+n }
        return possible.dropLast(1).withIndex().find { it.value > possible.last() - it.value }?.index?.inc()?:-1
    }
}
