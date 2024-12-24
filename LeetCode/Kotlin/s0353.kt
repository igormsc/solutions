class SnakeGame(width: Int, height: Int, food: Array<IntArray>) {
    private var score = 0
    private var ind = 0
    private val q = mutableListOf(0)
    private val vis= mutableSetOf(0)
    private val w = width
    private val h = height
    private val food = food

    fun move(direction: String): Int {
        val p = q.first()
        val (i, j) = p / w to p % w
        var x = i
        var y = j
        when (direction) {
            "U" -> x--
            "D" -> x++
            "L" -> y--
            else -> y++
        }
        if (x < 0 || x >= h || y < 0 || y >= w) return -1
        if (ind < food.size && x == food[ind][0] && y == food[ind][1]) score++.also{ind++}
        else {
            val t = q.removeLast()
            vis.remove(t)
        }
        val cur = f(x, y)
        if (vis.contains(cur)) return -1
        q.add(0, cur)
        vis.add(cur)
        return score
    }

    private fun f(i: Int, j: Int): Int = i * w + j

}