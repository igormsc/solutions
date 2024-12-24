import java.util.*

class Solution3112 {
    fun minimumTime(n: Int, edges: Array<IntArray>, disappear: IntArray): IntArray {
        val adj = Array(n){mutableListOf<Pair<Int,Int>>()}
        val res = IntArray(n) {-1}
        val pq = PriorityQueue<Pair<Int, Int>> { a, b -> if (a.first == b.first) a.second - b.second else a.first - b.first }

        edges.forEach { e ->
            adj[e[0]].add(e[1] to e[2])
            adj[e[1]].add(e[0] to e[2])
        }
        pq.add(0 to 0)

        while (pq.isNotEmpty()) {
            val (t, nd) = pq.poll()
            if (res[nd] != -1 || t >= disappear[nd]) continue
            res[nd] = t
            adj[nd].forEach { (i,j) -> if (t+j < disappear[i]) pq.add(t+j to i) }
        }

        return res
    }

}
