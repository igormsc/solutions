import java.io.BufferedReader
import java.io.InputStreamReader

// 39. Откуда достижима первая вершина

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,m) = reader.readLine().trim().split(' ').map(String::toInt)

    val g = (1..m).fold(Array(n) { mutableListOf<Int>() } ) { r, _ ->
        val (u, v) = reader.readLine().trim().split(' ').map{it.toInt()-1}
        r[v].add(u)
        r }
    reader.close()

    val vis = BooleanArray(n).also { it[0] = true }
    val q = mutableListOf(0)

    while (q.isNotEmpty()) {
        val u = q.removeFirst()
        g[u].forEach { v -> if (!vis[v]) {vis[v] = true; q.add(v) } }
    }

    println(vis.withIndex().filter { it.value }.map { it.index + 1 }.joinToString(" "))
}
