import java.io.BufferedReader
import java.io.InputStreamReader

// 43. Два коня

fun main(args: Array<String>) {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val crds = reader.readLine().trim().split(' ')
    reader.close()

    val (x1, y1) = crds[0][0].code - 'a'.code to crds[0][1].code - '0'.code - 1
    val (x2, y2) = crds[1][0].code - 'a'.code to crds[1][1].code - '0'.code - 1
    val field = Array(8) { IntArray(8) { Int.MAX_VALUE } }.also{it[x1][y1] = 0}
    val (dx, dy) = intArrayOf(2, 2, -2, -2, 1, 1, -1, -1) to intArrayOf(1, -1, 1, -1, 2, -2, 2, -2)

    val queue = mutableListOf(Pair(x1, y1))
    val visited = Array(8) { Array(8) { false } }.also{it[x1][y1] = true}

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        if (x == x2 && y == y2) {
            val dst = field[x2][y2]
            println(if (dst%2==0) dst/2 else -1)
            return }

        (0..<8).forEach { i->
            val (nx, ny) = x + dx[i] to y + dy[i]
            if (nx in 0..<8 && ny in 0..<8 && !visited[nx][ny]) {
                queue.add(nx to  ny)
                field[nx][ny] = field[x][y] + 1
                visited[nx][ny] = true } }
    }
    println(-1)
}