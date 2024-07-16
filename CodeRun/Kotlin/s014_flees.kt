import java.io.BufferedReader
import java.io.InputStreamReader

// 14. Блохи

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n,m,s,t,f) = reader.readLine().trim().split(' ').map(String::toInt)
    val coords = (1..f).fold(mutableListOf<Pair<Int, Int>>()) { r, _ ->
        r.add(reader.readLine().trim().split(' ').map(String::toInt).let{ it[0]-1 to it[1]-1})
        r }
    reader.close()

    val moves = mutableListOf(1 to 2, 1 to -2, 2 to 1, 2 to -1, -1 to 2, -1 to -2, -2 to 1, -2 to -1)
    val g = Array(n){IntArray(m) {-1} }

    fun bfs(x:Int, y: Int) {
        val q = mutableListOf(x to y)
        g[x][y] = 0

        while (q.isNotEmpty()) {
            val (i, j) = q.removeFirst()
            val dist = g[i][j]
            moves.forEach { (dx, dy) ->
                val (cx, cy) = i + dx to j + dy
                if (cx in 0..<n && cy in 0..<m && g[cx][cy] == -1) q.add(cx to cy).also { g[cx][cy] = dist + 1 }
            }
        }
    }

    bfs(s-1,t-1)
    var sum = 0
    for (crd in coords) {
        if (g[crd.first][crd.second] != -1) sum += g[crd.first][crd.second]
        else {sum = -1; break}
    }

    println(sum)
}