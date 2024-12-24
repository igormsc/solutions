import java.util.*

class Solution2714 {
    fun shortestPathWithHops(n: Int, edges: Array<IntArray>, s: Int, d: Int, k: Int): Int {
        val g = Array(n) {mutableListOf<IntArray>()}
        for (e in edges) {
            val (u,v,w) = e
            g[u].add(intArrayOf(v, w))
            g[v].add(intArrayOf(u, w))
        }
        val pq = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }
        pq.offer(intArrayOf(0, s, 0))
        val dist = Array(n) { IntArray(k + 1) { Int.MAX_VALUE/2} }
        dist[s][0] = 0
        while (!pq.isEmpty()) {
            val (dis,u,t) = pq.poll()
            for (e in g[u]) {
                val (v,w) = e
                if (t + 1 <= k && dist[v][t + 1] > dis) {
                    dist[v][t + 1] = dis
                    pq.offer(intArrayOf(dis, v, t + 1))
                }
                if (dist[v][t] > dis + w) {
                    dist[v][t] = dis + w
                    pq.offer(intArrayOf(dis + w, v, t))
                }
            }
        }
        return dist[d].min()
    }

}