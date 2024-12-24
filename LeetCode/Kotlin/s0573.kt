import kotlin.math.absoluteValue

class Solution573 {
    fun minDistance(height: Int, width: Int, tree: IntArray, squirrel: IntArray, nuts: Array<IntArray>): Int {
        val s = 2 * nuts.sumOf { f(it, tree) }

        return nuts.minOf { n ->
            val c = f(n, tree)
            val d = f(n, squirrel) + c
            s + d - c * 2
        }
    }

    private fun f(a: IntArray, b: IntArray): Int = (a[0] - b[0]).absoluteValue + (a[1] - b[1]).absoluteValue
}