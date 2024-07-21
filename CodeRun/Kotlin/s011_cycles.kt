import java.io.BufferedReader
import java.io.InputStreamReader

// 11. Поиск цикла

fun main(args: Array<String>) {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val nodes = reader.readLine().trim().toInt()
    val graph = (0..<nodes).fold(Array(nodes) { mutableListOf<Int>() }) { r, u ->
        reader.readLine().trim().split(" ").forEachIndexed { v, c ->
            if (c == "1") { r[u].add(v); r[v].add(u) } }
        r }
    reader.close()

    val visited = IntArray(graph.size)
    var cycle = listOf<Int>()

    fun dfs(v: Int, p: Int, path: MutableList<Int>): Boolean {
        visited[v] = 1
        path.add(v)
        for (u in graph[v]) {
            if (u != p && visited[u] != 2) {
                if (visited[u] == 1) {
                    cycle = path.subList(path.indexOf(u), path.size).map { it + 1 }
                    return true
                }
                if (visited[u] == 0 && dfs(u, v, path)) return true
            }
        }
        path.removeLast()
        visited[v] = 2
        return false
    }

    for (v in graph.indices) {
        if (dfs(v, -1, mutableListOf())) {
            println("YES")
            println(cycle.size)
            println(cycle.joinToString(" "))
            break
        }
    }
    if (cycle.isEmpty()) println("NO")
}