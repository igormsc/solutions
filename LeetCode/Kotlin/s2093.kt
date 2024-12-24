import java.util.*

class Solution2093 {
    fun minimumCost(n: Int, highways: Array<IntArray>, discounts: Int): Int {
        val g = Array(n){ mutableListOf<IntArray>() }
        for ((u, v, z) in highways) {
            g[u].add(intArrayOf(v, z))
            g[v].add(intArrayOf(u, z))
        }
        val q = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }
        q.offer(intArrayOf(0, 0, 0))
        val dist = Array(n) { IntArray(discounts + 1) {Int.MAX_VALUE} }
        while (q.isNotEmpty()) {
            val (cost, i, k) = q.poll()
            if (k > discounts || dist[i][k] <= cost) continue
            if (i == n - 1) return cost
            dist[i][k] = cost
            for ((j, v) in g[i]) {
                q.offer(intArrayOf(cost + v, j, k))
                q.offer(intArrayOf(cost + v / 2, j, k + 1))
            }
        }
        return -1
    }


}