import java.io.BufferedReader
import java.io.InputStreamReader

// https://cp-algorithms.com/graph/bipartite-check.html

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val inp = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    val (n, m) = inp[0] to inp[1] // n - nodes num, m - edges.
    val g = (0..<m).fold(Array(n+1) { mutableListOf<Int>() }) { r, i ->
        val inp = reader.readLine().split(" ").map { it.toInt() - 1 }.toIntArray()
        r[inp[0]].add(inp[1])
        r[inp[1]].add(inp[0])
        r
    }
    reader.close()

    val q = mutableListOf<Int>()
    val side = IntArray(n) {-1}
    var isBipartite = true

    side.indices.forEach { i ->
        if (side[i] == -1) {
            q.add(i)
            side[i] = 0
            while (q.isNotEmpty()) {
                val v = q.removeFirst()
                g[v].forEach { u ->
                    if (side[u] == -1) {
                        side[u] = side[v].xor(1)
                        q.add(u)
                    } else isBipartite = isBipartite.and(side[u]!=side[v])
                }
            }
        }
    }
    println(if (isBipartite) "YES" else "NO")
}