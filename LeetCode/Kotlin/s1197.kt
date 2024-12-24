import kotlin.math.absoluteValue

class Solution1197 {
    private val rg = arrayOf(intArrayOf(0, 3, 2), intArrayOf(3, 2, 1), intArrayOf(2, 1, 4))

    fun minKnightMoves(x: Int, y: Int): Int {
        var (x, y) = x.absoluteValue to y.absoluteValue
        if (x < y) x=y.also{y=x}
        if (x <= 2) return rg[x][y]
        return (if ((x - 3) >= (y - 3) * 2) (x - 1) / 2 + 1 else (x + y - 2) / 3 + 1).let { it + ((it + x + y ) % 2)}
    }

}
