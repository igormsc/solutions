class Solution1334 {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val adj = Array(n) {IntArray(n) { 10_001 }}
        edges.forEach { e ->
            adj[e[0]][e[1]] = e[2]
            adj[e[1]][e[0]] = e[2]
        }
        adj.indices.forEach { adj[it][it] = 0 }
        adj.indices.forEach { k ->
            adj.indices.forEach { i ->
                adj.indices.forEach { j ->
                    adj[i][j] = minOf(adj[i][k] + adj[k][j], adj[i][j]) }}}

        var res = 0
        var min = n
        adj.indices.forEach { i ->
            val c = adj.indices.count { adj[i][it] <= distanceThreshold }
            if ( c <= min) {
                res = i
                min = c
            }
        }
        return res
    }
}

