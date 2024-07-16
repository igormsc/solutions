import java.io.BufferedReader
import java.io.InputStreamReader

// 16. Метро

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    reader.readLine().trim().toInt()
    val m = reader.readLine().trim().toInt()

    val path = mutableMapOf<String, MutableSet<String>>()

    fun addEdge(v1: String, v2: String) {
        path.putIfAbsent(v1, mutableSetOf())
        path.putIfAbsent(v2, mutableSetOf())
        if (v1 != v2) path[v1]!!.add(v2).also { path[v2]!!.add(v1) }
    }

    (1..m).forEach { i ->
        val l = reader.readLine().trim().split(' ')
        (2..l.lastIndex).forEach { j ->
            val (e1, e2) = "e${l[j - 1]}" to "e${l[j]}"
            val (w1, w2) = "${i}_${l[j - 1]}" to "${i}_${l[j]}"

            addEdge(w1, w2)
            addEdge(w1, e1)
            addEdge(w2, e2)
        }
    }

    val (start, end) = reader.readLine().split(" ").map { "e${it}" }
    reader.close()

    fun bfs(v1: String, v2: String): Int {
        if (v1 == v2) return 0
        val vis = mutableSetOf<String>()
        var ind = 0
        val q = mutableMapOf(ind to mutableListOf(v1))

        while (q.containsKey(ind) && q[ind]!!.isNotEmpty()) {
            val v = q[ind]!!.removeFirst()
            vis.add(v)

            path[v]!!.forEach { n ->
                if (n == v2) return ind
                if (!vis.contains(n)) {
                    val dist = ind + if (n.startsWith('e')) 1 else 0
                    q.computeIfAbsent(dist) { mutableListOf() }
                    q[dist]!!.add(n)
                }
            }
            if (q[ind]!!.isEmpty()) ind++
        }
        return -1

    }
    println(bfs(start, end))
}