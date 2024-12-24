import kotlin.math.absoluteValue

class Solution3189 {
    fun minMoves(rooks: Array<IntArray>): Int {
        rooks.sortBy {it[0]}
        val s = rooks.indices.sumOf { (rooks[it][0] - it).absoluteValue }
        rooks.sortBy{it[1]}
        return s + rooks.indices.sumOf { (rooks[it][1] - it).absoluteValue }
    }

}