import java.io.BufferedReader
import java.io.InputStreamReader

// 15. Путь спелеолога

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    var y = -1
    var z = -1
    var start = Triple(0, 0, 0)
    val path = mutableMapOf<Triple<Int, Int, Int>, Int>()

    repeat(n*(n+1)) {
                val l = reader.readLine().trim()
                if (l== "") z++.also{y=-1}
                else {
                    y++
                    l.forEachIndexed{  x, c ->
                        val v = Triple(x, y, z)
                        if (c != '#') { path[v] = -1}
                        if (c == 'S') { start = v}
                    }
                }
            }

    val moves = mutableListOf(Triple(1,0,0),Triple(-1,0,0),
                              Triple(0,1,0), Triple(0,-1,0),
                              Triple(0,0,1), Triple(0,0,-1))

    fun bfs(start: Triple<Int, Int, Int>): Int {
            val q = mutableListOf(start)
            path[start] = 0

            while (q.isNotEmpty()) {
                val v = q.removeFirst()
                val dist = path[v] ?: 0
                if (v.third == 0) return dist

                moves.forEach { m ->
                    val c = Triple(v.first + m.first, v.second + m.second, v.third + m.third)
                    if (path.containsKey(c) && path[c] == -1) {
                        path[c] = dist + 1
                        q.add(c) }
                }
            }
            return -1
    }

    println(bfs(start))
    reader.close()
}