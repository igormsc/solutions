class Solution3248 {
    fun finalPositionOfSnake(n: Int, commands: List<String>): Int =
        commands.sumOf {
            when (it) {
                "RIGHT" -> 1
                "LEFT" -> -1
                "UP" -> -n
                "DOWN" -> n
                else -> 0
            }
        }
}
