import java.util.*

class Solution1902 {
    fun maxDepthBST(order: IntArray): Int {
        val tm = TreeMap<Int, Int>().also { it[0] = 0; it[Int.MAX_VALUE] = 0; it[order[0]] = 1 }
        return when (order.size) {
            0 -> 0
            1 -> 1
            else -> (1..order.lastIndex)
                .maxOf { i ->
                    val o = order[i]
                    (1 + maxOf(tm.lowerEntry(o).value, tm.higherEntry(o).value)).also { tm[o] = it }
                }
        }
    }
}