class Solution1041 {
    fun isRobotBounded(instructions: String): Boolean {
        var (x, y, i) = intArrayOf(0, 0, 0)
        val d = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        instructions.forEach {
            when (it) {
                'R' -> i = (i + 1) % 4
                'L' -> i = (i + 3) % 4
                else -> {
                    x += d[i].first
                    y += d[i].second
                }
            }
        }
        return x == 0 && y == 0 || i > 0
    }
}
