import java.util.*

class Solution2473 {
    fun minCost(n: Int, roads: Array<IntArray>, appleCost: IntArray, k: Int): LongArray {
            val cost = appleCost
            val g = Array(n){ mutableListOf<IntArray>() }
            val dist = IntArray(n)
            for (e in roads) {
                val u = e[0] - 1
                val v = e[1] - 1
                val c = e[2]
                g[u].add(intArrayOf(v, c))
                g[v].add(intArrayOf(u, c))
            }

            fun dijkstra(u: Int): Long {
                var u = u
                val q = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }
                q.offer(intArrayOf(0, u))
                dist.fill(Int.MAX_VALUE/2)
                dist[u] = 0
                var res = Long.MAX_VALUE
                while (!q.isEmpty()) {
                    val p = q.poll()
                    val d = p[0]
                    u = p[1]
                    res = minOf(res, (cost[u] + (k + 1).toLong() * d))
                    for (ne in g[u]) {
                        val (v,w) = ne
                        if (dist[v] > dist[u] + w) {
                            dist[v] = dist[u] + w
                            q.offer(intArrayOf(dist[v], v))
                        }
                    }
                }
                return res
            }

            return (0..<n).fold(LongArray(n)) { r, i -> r[i]= dijkstra(i); r}
        }

}