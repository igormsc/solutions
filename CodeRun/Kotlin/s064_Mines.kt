import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val inp = reader.readLine().split(" ").map { it.toInt() }
    val (m, n) = inp[0] to inp[1]
    val mines = inp[2]
    val field = (1..mines).fold(Array(m) { CharArray(n) }) { r, _ ->
        val crds = reader.readLine().split(" ").map { it.toInt() }
        r[crds[0]-1][crds[1]-1] = '*'
        r }
    reader.close()

    field.indices.forEach { x ->
        field[0].indices.forEach { y ->
            if (field[x][y] != '*')
                (-1..1).sumOf { dx ->
                        (-1..1).count { dy ->
                            val (cx, cy) = x + dx to y + dy
                            cx >= 0 && cy >= 0 && cx < m && cy < n && field[cx][cy] == '*'
                        } }.also { field[x][y] = (it + '0'.code).toChar() }
        }
    }

    field.forEach { row ->
        writer.write(row.joinToString(" "))
        writer.newLine()
    }
    writer.close()
}