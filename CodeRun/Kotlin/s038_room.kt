import java.io.BufferedReader
import java.io.InputStreamReader

// 38. Площадь комнаты

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().trim().toInt()
    val matrix = Array(n) { CharArray(n) }
    (0..<n).forEach { matrix[it] = reader.readLine().trim().toCharArray() }
    val (x, y) = reader.readLine().trim().split(' ').map { it.toInt()-1 }
    reader.close()

    val visited = Array(n) { BooleanArray(n) }
    fun dfs(x: Int, y: Int): Int =
        if (x < 0 || y < 0 || x >= matrix.size || y >= matrix[0].size || matrix[x][y] == '*' || visited[x][y]) 0
        else {
            visited[x][y] = true
            1 + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1) }

    if (matrix[x][y] == '*') println("Error: the cell is a wall")
    else println(dfs(x, y))
}
