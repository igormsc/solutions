import java.util.*

class Solution3123 {
    fun findAnswer(n: Int, edges: Array<IntArray>): BooleanArray {
        val res = BooleanArray(edges.size)
        val al = Array(n) { mutableListOf<Pair<Int, Int>>() }
        edges.forEachIndexed { i, e ->
            al[e[0]].add(e[1] to i)
            al[e[1]].add(e[0] to i)
        }
        val pq = PriorityQueue<Pair<Int, Int>> { a, b -> if (a.first == b.first) a.second - b.second else a.first - b.first }
        pq.add(0 to 0)
        val path = IntArray(n) { Int.MAX_VALUE }.also { it[0] = 0 }
        while (pq.isNotEmpty()) {
            val (l, i) = pq.poll()
            if (l == path[i])
                for ((j, e) in al[i])
                    if (l + edges[e][2] < path[j]) {
                        path[j] = l + edges[e][2]
                        pq.add(path[j] to j)
                    }
        }
        pq.add(path[n-1] to n-1)
        while (pq.isNotEmpty()) {
            val (l,i) = pq.poll()
            for ((j,e) in al[i])
                if (l-edges[e][2] == path[j]) {
                    res[e] = true
                    pq.add(path[j] to j)
                }
        }
        return res
    }
}
