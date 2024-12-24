class Solution657 {
    fun judgeCircle(moves: String): Boolean {
        var (x, y) = arrayOf(0, 0)
        moves.forEach {
            when (it) {
                'U' -> y++
                'D' -> y--
                'R' -> x++
                'L' -> x--
            }
        }
        return x == 0 && y == 0
    }
}
